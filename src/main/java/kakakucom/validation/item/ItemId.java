package kakakucom.validation.item;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * itemIdの存在チェック
 */
@Documented
@Constraint(validatedBy = {ItemIdValidator.class})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface ItemId {
    String message() default "invalid itemId";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        ItemId[] value();
    }
}
