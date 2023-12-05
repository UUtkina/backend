package ait.de.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDTOResponse {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Integer userId;

}
