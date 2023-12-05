package ait.de.shop_01_12.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationResponseDTO {
    private boolean success;
    private String message;
}
