package kakakucom.app.category;

import kakakucom.dto.CategoryDto;
import kakakucom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Nonnull;

/**
 * 商品大カテゴリーページ
 */
@Controller
public class LargeCategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/{largeCategoryCd}", method = RequestMethod.GET)
    public String showCategory(
        @PathVariable @Nonnull String largeCategoryCd,
        Model model
    ) {

        CategoryDto category = categoryService.fetchOneByLargeCd(largeCategoryCd);

        model.addAttribute("category", category);

        return "category/largeCategory";
    }
}
