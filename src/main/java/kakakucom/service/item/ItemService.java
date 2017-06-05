package kakakucom.service.item;

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

    public Item fetchOne(@Nonnull String itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> fetchTopItemsByLargeCategoryCd(@Nonnull String largeCategoryCd) {
        return itemRepository.findTopItemsByLargeCategoryCd(largeCategoryCd);
    }

    public List<Item> fetchTopItemsBySmallCategoryCd(@Nonnull String smallCategoryCd) {
        return itemRepository.findTopItemsBySmallCategoryCd(smallCategoryCd);
    }
}
