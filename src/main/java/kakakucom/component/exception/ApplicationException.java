package kakakucom.component.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.annotation.Nonnull;

@Getter
public class ApplicationException extends RuntimeException {

    /**
     * HTTPステータスコード
     */
    private final HttpStatus statusCode;

    /**
     * コンストラクタ
     *
     * @param statusCode to set
     * @param message エラーメッセージ
     */
    ApplicationException(@Nonnull final HttpStatus statusCode,
                         @Nonnull final String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * コンストラクタ
     *
     * @param statusCode to set
     * @param cause to set
     */
    ApplicationException(@Nonnull final HttpStatus statusCode,
                         @Nonnull final Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    /**
     * コンストラクタ
     *
     * @param statusCode to set
     */
    ApplicationException(@Nonnull final HttpStatus statusCode) {
        super();
        this.statusCode = statusCode;
    }
}
