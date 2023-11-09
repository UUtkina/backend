package ait.de.dto;

import ait.de.entety.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private Integer id;
    private String name;
    private String email;
    private boolean isActive;

    public static User toUser(UserRequestDTO userRequestDTO){
        return  new User(null, userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.isActive());
    }

    public static List<User> toUser(List<UserRequestDTO>userRequestDTOS){
        return userRequestDTOS.stream().map(UserRequestDTO::toUser)
                .toList();
    }
}
