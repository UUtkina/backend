package ait.de.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTORequest {
    private Integer id;
    private String name;
    private String email;
    private String password;
   }
