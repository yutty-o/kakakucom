package kakakucom.app.item;

import kakakucom.model.Item;
import kakakucom.model.StoreItem;
import kakakucom.service.item.ItemService;
import kakakucom.service.storeitem.StoreItemService;
import kakakucom.validation.item.ItemId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Validated
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    StoreItemService storeItemService;

    @RequestMapping(value = "/{itemId}")
    public String itemDetail (
        @PathVariable("itemId") @ItemId final String itemId,
        Model model
    ) {
        Item item = itemService.fetchOne(itemId);
        List<StoreItem> storeItems = storeItemService.fetchByItemIdOrderByPriceASC(itemId);

        model.addAttribute("item", item);
        model.addAttribute("storeItems", storeItems);
        return "item/itemDetail";
    }
}
