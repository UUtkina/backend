package ait.de.entety;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ToDo {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private User author;

    public ToDo() {

    }
}