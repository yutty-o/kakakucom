package kakakucom.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LargeCategory implements Serializable {
    private String largeCategoryCd;
    private String name;
}
