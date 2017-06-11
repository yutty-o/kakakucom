package kakakucom.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreItem {
    private Integer storeItemId;
    private Integer storeId;
    private Integer itemId;
    private Integer price;
    private Integer stock;
    private String shippingPeriod;
    private String area;
    private String comment;
    private String color;
    private String url;
    private String storeName;
    private String storeUrl;
    private Boolean bankPay;
    private Boolean creditPay;
    private Boolean conveniencePay;
}
