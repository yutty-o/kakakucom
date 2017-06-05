package kakakucom.service.storeitem;

import kakakucom.model.StoreItem;
import kakakucom.repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreItemService {

    @Autowired
    StoreItemRepository storeItemRepository;

    public List<StoreItem> fetchByItemIdOrderByPriceDesc(final String itemId) {
        return storeItemRepository.findByItemIdOrderByPriceDesc(itemId);
    }
}
