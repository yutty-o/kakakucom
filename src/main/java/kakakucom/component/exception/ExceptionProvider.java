package kakakucom.component.exception;

import org.springframework.http.HttpStatus;
import javax.annotation.Nonnull;

public class ExceptionProvider {

    /**
     * 対象のリソースが見つからない場合
     */
    public ApplicationException notFoundResources(@Nonnull final String message) {
        return new ApplicationException(
            HttpStatus.NOT_FOUND,
            message
        );
    }
}
