package kakakucom.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Item implements Serializable {
    private Integer itemId;
    private String name;
    private String imagePath;
    private Integer minPrice;
    private String largeCategoryCd;
    private String largeCategoryName;
    private String smallCategoryCd;
    private String smallCategoryName;
    private String description;
}
