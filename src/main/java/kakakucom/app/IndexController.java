package kakakucom.app;

import kakakucom.dto.CategoryDto;
import kakakucom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * トップページ
 * Created by ogawayuuki on 2017/04/12
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        List<CategoryDto> categories = categoryService.fetchCategories();
        model.addAttribute("categories", categories);
        return "index";
    }
}
