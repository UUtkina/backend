package org.group28projectjpa_21_11.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.group28projectjpa_21_11.dto.manager.ManagerResponseDTO;
import org.group28projectjpa_21_11.entyty.TaskStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseAllDTO {

        private Integer id;
        private String taskName;
        private String description;
        private LocalDateTime createDate;
        private LocalDateTime lastUpdate;
        private LocalDateTime deadline;
        private TaskStatus status;
        private ManagerResponseDTO managerResponseDTO;
    }

