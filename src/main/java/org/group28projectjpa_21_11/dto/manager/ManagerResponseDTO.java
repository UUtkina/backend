package org.group28projectjpa_21_11.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.group28projectjpa_21_11.entyty.Role;



@Data
@AllArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    public Role name;

    public ManagerResponseDTO(Integer id, String managerName, String email, String roleName) {
    }
}