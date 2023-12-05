package ait.de.shop_01_12.dto.order;

import ait.de.shop_01_12.dto.user.ResponseUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
public class OrderResponseDTO {
    private Integer id;
    private String orderStatus;
    private String paymentStatus;
    private String paymentMethod;
    private LocalDateTime createDate;
    private ResponseUserDTO user;
    private List<OrderItemDTO> orderItems;


}