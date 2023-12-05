package org.group28projectjpa_21_11.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ManagerCreateResponseDTO {

    private Integer id;
    private String managerName;
    private LocalDateTime createManagerDate;
    private LocalDateTime lastUpdate;

}