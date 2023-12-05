package ait.de.dto;


import ait.de.entety.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ToDoRequest {

    private String title;
    private String description;
    private Integer userId;
  }
