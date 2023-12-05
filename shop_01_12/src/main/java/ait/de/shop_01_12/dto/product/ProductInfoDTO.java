package ait.de.shop_01_12.dto.product;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class ProductInfoDTO {
    private BigDecimal price;
    private int quantity;
}
