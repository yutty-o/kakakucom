package kakakucom.validation;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 小カテゴリーCDの存在チェックロジック
 */
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
        // 適切な小カテゴリーCDではない場合、独自のexceptionをthrowする
        if (!categoryService.isValidSmallCategoryCd(value.toString())) {
            throw exceptionProvider.notFoundResources(
                "invalid smallCategoryCd"
            );
        }
        // 便宜上trueで返却する
        return true;
    }
}
