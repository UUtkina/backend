package ait.de.dto;

import ait.de.entety.ToDo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class ToDoResponseDTO {
    private Integer id;
    private Integer userId;
    private String description;
    private boolean isCompleted;

    public static ToDoResponseDTO from(ToDo toDo){
        return new ToDoResponseDTO(toDo.getId(), toDo.getUserId(), toDo.getDescription(),toDo.isCompleted());

    }

    public static List<ToDoResponseDTO> from(List<ToDo> toDoList) {
        return toDoList.stream()
                .map(ToDoResponseDTO::from)
                .collect(Collectors.toList());
    }

}
