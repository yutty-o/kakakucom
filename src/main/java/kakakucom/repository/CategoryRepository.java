package kakakucom.repository;

import kakakucom.model.LargeCategory;
import kakakucom.model.SmallCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Nonnull;
import java.util.List;

@Mapper
public interface CategoryRepository {

    List<LargeCategory> findAllLargeCategories(
    );

    LargeCategory findOneLargeCategory(
        @Param("largeCategoryCd") @Nonnull String largeCategoryCd
    );

    List<SmallCategory> findAllSmallCategories(
    );

    List<SmallCategory> findSmallCategoriesByLargeCd(
        @Param("largeCategoryCd") @Nonnull String largeCategoryCd
    );

    int countLargeCategoryByLargeCd(
        @Param("largeCategoryCd") @Nonnull String largeCategoryCd
    );

    int countSmallCategoryBySmallCd(
        @Param("smallCategoryCd") @Nonnull String smallCategoryCd
    );
}
