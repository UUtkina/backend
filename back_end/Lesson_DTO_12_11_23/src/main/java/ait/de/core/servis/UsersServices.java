package ait.de.core.servis;


import ait.de.core.util.UserConverters;
import ait.de.core.validation.NotFoundException;
import ait.de.dto.UserDTORequest;
import ait.de.dto.UserDTOResponse;
import ait.de.repository.ToDoRepository;
import ait.de.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ait.de.entety.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServices {
    private final ToDoRepository repository;
    private final UserRepository userRepository;
    private final UserConverters userConverters;
    private List<User> database = new ArrayList<>();
    /*
  addUser
  findAllUser
  findUserByID
  updateUser
    */

    public UserDTOResponse userAdd(UserDTORequest request) {
        User newUser = userConverters.convectorFromRequestToUser(request);
        newUser = userRepository.save(newUser);
        return userConverters.convectorUserToResponse(newUser);
    }

    public List<UserDTOResponse> getAllUser() {
        List<User> list = userRepository.findAll();
        return list.stream()
                .map(userConverters::convectorUserToResponse)
                .toList();
    }

    public UserDTOResponse updateUser(Integer id, UserDTORequest userDTORequest) {
        Optional<User> userOptional= userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userForUpdate = userOptional.get();
            userForUpdate.setName(userDTORequest.getName());
            userForUpdate.setEmail(userDTORequest.getEmail());
            userForUpdate.setPassword(userDTORequest.getPassword());
            User updateUser = userRepository.save(userForUpdate);
            return userConverters.convectorUserToResponse(updateUser);
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }
    }

    public UserDTOResponse findUserByID(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return userConverters.convectorUserToResponse(user);
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }

    }

  }

