package kakakucom.controller.account;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class AccountForm implements Serializable {

    @Size(min = 1, max = 40)
    @NotNull
    private String name;

    @Size(min = 6)
    @NotNull
    private String password;

    @NotNull
    private String passwordConfirm;
}
