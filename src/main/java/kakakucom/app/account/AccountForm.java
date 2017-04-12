package kakakucom.app.account;

import kakakucom.validation.Confirm;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Confirm(field = "password")
public class AccountForm implements Serializable {

    @Size(min = 1, max = 32)
    @NotNull
    private String name;

    @Email
    @Size(min = 1, max = 50)
    @NotNull
    private String email;

    @Size(min = 6)
    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;
}
