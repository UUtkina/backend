package ait.de.shop_01_12.dto.cart;

import ait.de.shop_01_12.dto.user.ResponseUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseCartDTO {
    private Integer id;
    private ResponseUserDTO userDTO;
    private List<CartItemDTO> cartItems;


}
