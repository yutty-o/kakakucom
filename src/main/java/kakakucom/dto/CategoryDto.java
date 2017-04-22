package kakakucom.dto;

import kakakucom.model.LargeCategory;
import kakakucom.model.SmallCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private LargeCategory largeCategory;
    private List<SmallCategory> smallCategories;
}
