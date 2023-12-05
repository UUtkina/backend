package org.group28projectjpa_21_11.dto.manager;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerCreateRequestDTO {

    private String managerName;
    private String password;
    private String email;


}