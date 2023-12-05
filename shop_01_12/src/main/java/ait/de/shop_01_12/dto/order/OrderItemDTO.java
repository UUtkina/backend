package ait.de.shop_01_12.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Integer productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
}
