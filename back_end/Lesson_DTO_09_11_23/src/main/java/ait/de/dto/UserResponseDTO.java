package ait.de.dto;

import ait.de.entety.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //@Data— это удобная краткая аннотация, которая объединяет функции @ToString,
// @EqualsAndHashCode, @Getter/@Setter и @RequiredArgsConstructorвмест
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private boolean isActive;

    public static UserResponseDTO from(User user){
        return new UserResponseDTO(user.getId(),
                user.getName(),
                user.getEmail(),
                user.isActive());
    }

    public static List<UserResponseDTO> from(List<User>users){
        return users.stream()
                .map(UserResponseDTO::from)
                .toList();
    }


}
