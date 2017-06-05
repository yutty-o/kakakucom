package kakakucom.app.item;

import kakakucom.model.Item;
import kakakucom.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/{itemId}")
    public String itemDetail (
        @PathVariable("itemId") final String itemId,
        Model model
    ) {
        Item item = itemService.fetchOne(itemId);
        model.addAttribute("item", item);
        return "item/itemDetail";
    }
}
