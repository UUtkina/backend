package ait.de.shop_01_12.dto.cart;

import ait.de.shop_01_12.dto.product.ProductCartInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.List;

@Schema(name = "Cart", description = "Cart data")
public class CartDto {
    @Schema(description = "Cart identifier", example = "1")
    private Integer id;
    @Schema(description = "User identifier", example = "14")
    private Integer userId;
    @Schema(description = "Products", example = "14")
    List<ProductCartInfoDto> products;
}