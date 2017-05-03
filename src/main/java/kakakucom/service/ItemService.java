package kakakucom.service;

import kakakucom.model.Item;
import kakakucom.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    /**
     * 大カテゴリーに当てはまる商品情報を取得します。
     *
     * @param 大カテゴリーCD
     * @return 商品情報
     */
    public List<Item> fetchTopItemsByLargeCategoryCd(@Nonnull String largeCategoryCd) {
        return itemRepository.findTopItemsByLargeCategoryCd(largeCategoryCd);
    }
}
