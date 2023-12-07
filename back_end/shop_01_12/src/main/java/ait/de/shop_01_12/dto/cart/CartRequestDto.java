package ait.de.shop_01_12.dto.cart;

import io.swagger.v3.oas.annotations.media.Schema;

public class CartRequestDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
     @Schema(description = "Quantity of the product", example = "24")
    int quantity;
}
