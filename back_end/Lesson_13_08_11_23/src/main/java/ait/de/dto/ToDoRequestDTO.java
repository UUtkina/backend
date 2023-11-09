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
public class ToDoRequestDTO {
    private Integer id;
    private Integer userId;
    private String description;
    private boolean isCompleted;


    public static ToDo toToDo(ToDoRequestDTO toDoRequestDTO){
        return  new ToDo(null,toDoRequestDTO.getUserId(), toDoRequestDTO.getDescription(), toDoRequestDTO.isCompleted());
    }

    public static List<ToDo> toToDoList(List<ToDoRequestDTO> toDoRequestDTOList) {
        return toDoRequestDTOList.stream()
                .map(ToDoRequestDTO::toToDo)
                .collect(Collectors.toList());
    }
}
