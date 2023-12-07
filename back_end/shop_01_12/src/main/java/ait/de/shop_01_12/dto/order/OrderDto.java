package ait.de.shop_01_12.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import ait.de.shop_01_12.dto.user.UserDto;

public class OrderDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
    @Schema(description = "User info")
    UserDto user;

    @Schema(description = "Status of order", example = "delivered")
    String orderStatus;
    @Schema(description = "Status of payment", example = "paid")
    String payment_status;

    @Schema(description = "Status of payment method", example = "paypal")
    String paymentMethod;

    @Schema(description = "The date and time when the object was created", example = "2023-12-01T15:30:45")
    private LocalDateTime createData;
}