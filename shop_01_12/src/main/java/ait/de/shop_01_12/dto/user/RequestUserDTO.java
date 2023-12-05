package ait.de.shop_01_12.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestUserDTO {
    private String username;
    private String password;
    private String email;
}
