package ait.de.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private Integer id;
    private String name;
    private String email;
     private LocalDateTime creationUser;
    private LocalDateTime lastVisitDate;


}
