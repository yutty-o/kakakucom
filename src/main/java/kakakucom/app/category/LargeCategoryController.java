package kakakucom.app.category;

import kakakucom.dto.CategoryDto;
import kakakucom.model.Item;
import kakakucom.service.CategoryService;
import kakakucom.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 大カテゴリーページ
 */
@Controller
public class LargeCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/{largeCategoryCd}")
    public String showCategory( @PathVariable @Nonnull String largeCategoryCd, Model model ) {
        CategoryDto category = categoryService.fetchOneByLargeCd(largeCategoryCd);
        List<Item>  items = itemService.fetchTopItemsByLargeCategoryCd(largeCategoryCd);
        model.addAttribute("category", category);
        model.addAttribute("items", items);
        return "category/largeCategory";
    }
}
