package kakakucom.repository;

import kakakucom.model.LargeCategory;
import kakakucom.model.SmallCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品カテゴリレポジトリ
 * Created by ogawayuuki on 2017/04/15.
 */
@Mapper
public interface CategoryRepository {

    List<LargeCategory> findLargeCategories();

    List<SmallCategory> findSmallCategories();

}
