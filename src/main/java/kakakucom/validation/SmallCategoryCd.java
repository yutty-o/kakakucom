package kakakucom.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 小カテゴリーCDの存在チェック
 */
@Documented
@Constraint(validatedBy = {SmallCategoryCdValidator.class})
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface SmallCategoryCd {
    String message() default "inValid smallCategoryCd";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        SmallCategoryCd[] value();
    }
}