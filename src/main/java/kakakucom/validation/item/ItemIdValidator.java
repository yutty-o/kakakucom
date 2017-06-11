package kakakucom.validation.item;

import kakakucom.component.exception.ExceptionProvider;
import kakakucom.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ItemIdValidator implements ConstraintValidator<ItemId, Object> {

    @Autowired
    ItemService itemService;

    @Autowired
    ExceptionProvider exceptionProvider;

    private String message;

    public void initialize(ItemId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 適切なitemIdでない場合、exceptionをthrowする。
        if(!itemService.isValidItemId(value.toString())) {
            throw exceptionProvider.notFoundResources(message);
        }
        // 便宜上trueで返却する
        return true;
    }
}
