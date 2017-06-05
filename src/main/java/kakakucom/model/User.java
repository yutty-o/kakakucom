package kakakucom.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private String password;
    private Boolean isDeleted;
}
