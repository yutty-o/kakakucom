package kakakucom.repository;

import kakakucom.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Nonnull;
import java.util.List;

@Mapper
public interface ItemRepository {

    List<Item> findTopItemsByLargeCategoryCd(
        @Param("largeCategoryCd") @Nonnull String largeCategoryCd
    );

    List<Item> findTopItemsBySmallCategoryCd(
        @Param("smallCategoryCd") @Nonnull String smallCategoryCd
    );
}
