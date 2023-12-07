package ait.de.shop_01_12.dto.order;

import ait.de.shop_01_12.dto.product.ProductCartInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class OrderRequestDTO {
    @Schema(description = "Cart identifier", example = "1")
    private Integer cartId;
    @Schema(description = "User identifier", example = "14")
    private Integer userId;
    List<ProductCartInfoDto>productCartInfoDtos;
}
