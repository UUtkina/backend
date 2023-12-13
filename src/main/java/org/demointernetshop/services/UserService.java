package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.dto.user.UserUpdateDto;
import org.demointernetshop.entity.Role;
import org.demointernetshop.entity.User;
import org.demointernetshop.repository.RoleRepository;
import org.demointernetshop.repository.UserRepository;
import org.demointernetshop.services.utils.Converters;
import org.demointernetshop.services.validation.IsAlreadyExistException;
import org.demointernetshop.services.validation.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final Converters converters;
    private final RoleRepository roleRepository;
    @SneakyThrows
    public UserDto createUser(UserRegistrationDto request) {
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            User newUser = converters.fromDto(request);

            Optional<Role> defaultRole = roleRepository.findByName("user");
            if (defaultRole.isPresent()) {
                newUser.setRole(defaultRole.get());
            } else {
                throw new NotFoundException("Schade");
            }
            newUser.setCreateData(LocalDateTime.now());
            newUser.setLastVisitData(LocalDateTime.now());
            User user = userRepository.save(newUser);
            return converters.from(user);
        } else {
            throw new IsAlreadyExistException("User with name " +request.getUsername() + " is already exist.");
        }
    }


    public UserDto updateUser(Integer userId, UserUpdateDto request) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            if (request.getEmail() != null) {
                user.setEmail(request.getEmail());
            }
            if (request.getPassword() != null) {
                user.setPassword(request.getPassword());
            }
            if (request.getUsername() != null) {
                user.setUsername(request.getUsername());
            }
            if (request.getPhone() != null) {
                user.setPhone(request.getPhone());
            }

            User updatedUser = userRepository.save(user);

            return converters.from(updatedUser);
        } else {
            throw new NotFoundException("Unfortunately, such a user does not exist");}
    }
}