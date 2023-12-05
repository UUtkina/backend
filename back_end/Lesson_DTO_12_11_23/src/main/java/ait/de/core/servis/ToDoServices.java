package ait.de.core.servis;

import ait.de.core.util.ToDoConverters;
import ait.de.core.validation.NotFoundException;
import ait.de.dto.ToDoDTOResponse;
import ait.de.dto.ToDoRequest;
import ait.de.entety.ToDo;
import ait.de.repository.ToDoRepository;
import ait.de.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

@AllArgsConstructor
public class ToDoServices {
    /*
    addTodo
    findAllTodo
    findTodoByID
    findTodoByUserId
    updateTodo
    deleteTodo
     */
    private final ToDoRepository repository;
    private final UserRepository userRepository;
    private final ToDoConverters converters;
    private List<ToDo> database = new ArrayList<>();


    public ToDoDTOResponse addToDo(ToDoRequest request) {

        ToDo newToDo = converters.convectorFromRequestToToDo(request);
        newToDo = repository.save(newToDo);
        return converters.convectorToDoToResponse(newToDo);
    }

    public List<ToDoDTOResponse> getAllToDo() {
        List<ToDo> list = repository.findAll();
        return list.stream()
                .map(converters::convectorToDoToResponse)
                .toList();
    }

    public ToDoDTOResponse updateToDo(Integer id, ToDoRequest toDoRequest) {
        Optional<ToDo> toDoOptional = repository.findById(id);
        if (toDoOptional.isPresent()) {
            ToDo todoForUpdate = toDoOptional.get();
            todoForUpdate.setTitle(toDoRequest.getTitle());
            todoForUpdate.setDescription(toDoRequest.getDescription());
            ToDo updateToDo = repository.save(todoForUpdate);
            return converters.convectorToDoToResponse(updateToDo);
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }
    }

    public ToDoDTOResponse findTodoByID(Integer id) {
        Optional<ToDo> toDoOptional = repository.findById(id);
        if (toDoOptional.isPresent()) {
            ToDo todo = toDoOptional.get();
            return converters.convectorToDoToResponse(todo);
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }

    }

    public List<ToDoDTOResponse> findTodoByUserId(Integer userId) {
        List<ToDo> listTodo = repository.findByUserId(userId);
        return listTodo.stream()
                .map(converters::convectorToDoToResponse)
                .toList();

    }

    public boolean delete(Integer id) {
        Optional<ToDo> toDoOptional = repository.findById(id);
        if (toDoOptional.isEmpty()) {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }
        database.remove(toDoOptional.get());
        return true;


    }
}