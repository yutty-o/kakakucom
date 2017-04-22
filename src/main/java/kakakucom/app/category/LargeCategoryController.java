package kakakucom.app.category;

import kakakucom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 大カテゴリーページ
 * Created by ogawayuuki on 2017/04/22.
 */
@Controller
public class LargeCategoryController {

    @Autowired
    CategoryService categoryService;
}
