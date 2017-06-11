package kakakucom.repository;

import kakakucom.model.StoreItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Nonnull;
import java.util.List;

@Mapper
public interface StoreItemRepository {

    List<StoreItem> findByItemIdOrderByPriceASC(
        @Param("itemId") @Nonnull String itemId
    );
}
