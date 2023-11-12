package ait.de.core.util;

import ait.de.core.validation.NotFoundException;
import ait.de.dto.ToDoDTOResponse;
import ait.de.dto.ToDoRequest;
import ait.de.entety.ToDo;
import ait.de.entety.User;
import ait.de.repository.ToDoRepository;
import ait.de.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ToDoConverters {
    private final ToDoRepository repository;
    private final UserRepository userRepository;

    public ToDo convectorFromRequestToToDo(ToDoRequest request) {
        Optional<User> author = userRepository.findById(request.getUserId());

        if (userRepository.findById(request.getUserId()).isEmpty()) {
            throw new NotFoundException("Request user id not found");
        }
        ToDo entity = new ToDo();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setCreationDate(LocalDateTime.now());
        entity.setAuthor(userRepository.findById(request.getUserId()).get());
        return entity;
    }

    public ToDoDTOResponse convectorToDoToResponse(ToDo entity) {
        ToDoDTOResponse response = new ToDoDTOResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setCreationDate(entity.getCreationDate());
        response.setUserId(entity.getAuthor().getId());
        return response;
    }
}
