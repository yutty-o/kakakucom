package kakakucom.app.category;

import kakakucom.dto.CategoryDto;
import kakakucom.model.Item;
import kakakucom.service.CategoryService;
import kakakucom.service.ItemService;
import kakakucom.validation.LargeCategoryCd;
import kakakucom.validation.SmallCategoryCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Validated
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/{largeCategoryCd}")
    public String largeCategory(
        @PathVariable("largeCategoryCd") @LargeCategoryCd final String largeCategoryCd,
        Model model
    ) {
        CategoryDto category = categoryService.fetchOneByLargeCd(largeCategoryCd);
        List<Item>  items = itemService.fetchTopItemsByLargeCategoryCd(largeCategoryCd);
        model.addAttribute("category", category);
        model.addAttribute("items", items);
        return "category/largeCategory";
    }

    @RequestMapping(value = "/{largeCategoryCd}/{smallCategoryCd}")
    public String smallCategory(
        @PathVariable("largeCategoryCd") @LargeCategoryCd final String largeCategoryCd,
        @PathVariable("smallCategoryCd") @SmallCategoryCd final String smallCategoryCd,
        Model model
    ) {
        CategoryDto category = categoryService.fetchOneByLargeCd(largeCategoryCd);
        List<Item> items = itemService.fetchTopItemsBySmallCategoryCd(smallCategoryCd);
        model.addAttribute("category", category);
        model.addAttribute("items", items);
        model.addAttribute("selectedSmallCategoryCd", smallCategoryCd);
        return "category/smallCategory";
    }
}
