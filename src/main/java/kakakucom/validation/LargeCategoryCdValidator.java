package kakakucom.validation;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 大カテゴリーCDの存在チェックロジック
 */
public class LargeCategoryCdValidator implements ConstraintValidator<LargeCategoryCd, Object> {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ExceptionProvider exceptionProvider;

    private String message;

    public void initialize(LargeCategoryCd constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 適切な大カテゴリーCDではない場合、独自のexceptionをthrowする
        if (!categoryService.isValidLargeCategoryCd(value.toString())) {
            throw exceptionProvider.notFoundResources(
                "invalid largeCategoryCd"
            );
        }
        // 便宜上trueで返却する
        return true;
    }
}
