package kakakucom.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private Boolean isDeleted;
}
