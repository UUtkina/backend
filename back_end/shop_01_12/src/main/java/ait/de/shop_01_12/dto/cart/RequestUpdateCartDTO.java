package ait.de.shop_01_12.dto.cart;

import ait.de.shop_01_12.entyty.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestUpdateCartDTO {
    private Integer id;
    private Product product;
    private int quantity;
}
