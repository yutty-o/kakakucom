package kakakucom.validation.category;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SmallCategoryCdValidator implements ConstraintValidator<SmallCategoryCd, Object> {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ExceptionProvider exceptionProvider;

    private String message;

    public void initialize(SmallCategoryCd constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 適切な小カテゴリーCDではない場合、exceptionをthrowする
        if (!categoryService.isValidSmallCategoryCd(value.toString())) {
            throw exceptionProvider.notFoundResources(message);
        }
        // 便宜上trueで返却する
        return true;
    }
}
