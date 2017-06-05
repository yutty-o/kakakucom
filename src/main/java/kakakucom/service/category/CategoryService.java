package kakakucom.service.category;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.dto.CategoryDto;
import kakakucom.model.LargeCategory;
import kakakucom.model.SmallCategory;
import kakakucom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ExceptionProvider exceptionProvider;


    /**
     * 全ての商品カテゴリー情報を取得します。
     *
     * @return 商品カテゴリー情報
     */
    public List<CategoryDto> fetchAll() {

        // 大カテゴリ・小カテゴリ情報を取得
        final List<LargeCategory> largeCategories = categoryRepository.findAllLargeCategories();
        final List<SmallCategory> smallCategories = categoryRepository.findAllSmallCategories();

        // CategoryDtoに変換して返却する。
        return largeCategories.stream()
            .map(largeCategory ->
                new CategoryDto(
                    largeCategory,
                    smallCategories.stream()
                        .filter(smallCategory -> smallCategory.getLargeCategoryCd().equals(largeCategory.getLargeCategoryCd()))
                        .collect(Collectors.toList())
                )
            )
            .collect(Collectors.toList());
    }

    /**
     * 大カテゴリーCDからカテゴリー情報を取得します。
     *
     * @param 大カテゴリーCD
     * @return 商品カテゴリー情報
     */
    public CategoryDto fetchOneByLargeCd(@Nonnull final String largeCategoryCd) {

        // 大カテゴリ・小カテゴリ情報を取得
        final LargeCategory largeCategory = categoryRepository.findOneLargeCategory(largeCategoryCd);
        final List<SmallCategory> smallCategories = categoryRepository.findSmallCategoriesByLargeCd(largeCategoryCd);

        return new CategoryDto(
            largeCategory,
            smallCategories
        );
    }

    /**
     * 大カテゴリーCDが適切か確認します。
     *
     * @param 大カテゴリーCD
     * @return 指定の大カテゴリーが存在するか
     */
    public boolean isValidLargeCategoryCd(@Nonnull final String largeCategoryCd) {
        return ( categoryRepository.countLargeCategoryByLargeCd(largeCategoryCd) != 0 );
    }

    /**
     * 小カテゴリーCDが適切か確認します。
     *
     * @param 小カテゴリーCD
     * @return 指定の小カテゴリーが存在するか
     */
    public boolean isValidSmallCategoryCd(@Nonnull final String smallCategoryCd) {
        return ( categoryRepository.countSmallCategoryBySmallCd(smallCategoryCd) != 0 );
    }
}
