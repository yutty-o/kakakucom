package kakakucom.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SmallCategory implements Serializable {
    private String smallCategoryCd;
    private String largeCategoryCd;
    private String name;
}
