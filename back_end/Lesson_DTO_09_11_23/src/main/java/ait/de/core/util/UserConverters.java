package ait.de.core.util;


import ait.de.dto.UserDTORequest;
import ait.de.dto.UserDTOResponse;
import ait.de.entety.User;
import ait.de.repository.ToDoRepository;
import ait.de.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserConverters {
    private final ToDoRepository repository;
    private final UserRepository userRepository;

    public User convectorFromRequestToUser(UserDTORequest userDTORequest) {
        User entity = new User();
        entity.setId(userDTORequest.getId());
        entity.setName(userDTORequest.getName());
        entity.setEmail(userDTORequest.getEmail());
        entity.setPassword(userDTORequest.getPassword());
        entity.setActive(true);
        entity.setCreationUser(LocalDateTime.now());
        return entity;
    }

    public UserDTOResponse convectorUserToResponse(User entity) {
        UserDTOResponse userDTOResponse = new UserDTOResponse();
        userDTOResponse.setId(entity.getId());
        userDTOResponse.setName(entity.getName());
        userDTOResponse.setEmail(entity.getEmail());
        userDTOResponse.setCreationUser(LocalDateTime.now());
        userDTOResponse.setLastVisitDate(LocalDateTime.now());
        return userDTOResponse;
    }
}
