package kakakucom.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private Boolean isDeleted;
}
