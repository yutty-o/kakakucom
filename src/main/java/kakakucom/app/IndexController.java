package kakakucom.app;

import kakakucom.dto.CategoryDto;
import kakakucom.model.LargeCategory;
import kakakucom.service.IndexService;
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
    IndexService indexService;

    @RequestMapping("/")
    public String index(Model model) {
        List<CategoryDto> categories = indexService.fetchCategories();
        model.addAttribute("categories", categories);
        return "index";
    }
}
