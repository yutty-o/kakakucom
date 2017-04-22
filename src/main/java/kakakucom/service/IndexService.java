package kakakucom.service;

import kakakucom.dto.CategoryDto;
import kakakucom.model.LargeCategory;
import kakakucom.model.SmallCategory;
import kakakucom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ogawayuuki on 2017/04/15.
 */
@Service
@Transactional
public class IndexService {

    @Autowired
    CategoryRepository categoryRepository;


    /**
     * 全ての商品カテゴリー情報を取得します。
     *
     * @return 商品カテゴリー情報
     */
    public List<CategoryDto> fetchCategories() {

        // 大カテゴリ・小カテゴリ情報を取得
        final List<LargeCategory> largeCategories = categoryRepository.findLargeCategories();
        final List<SmallCategory> smallCategories = categoryRepository.findSmallCategories();

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


}
