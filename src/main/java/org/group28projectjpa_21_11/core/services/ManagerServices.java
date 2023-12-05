package org.group28projectjpa_21_11.core.services;

import lombok.AllArgsConstructor;
import org.group28projectjpa_21_11.core.utils.ManagerConverter;
import org.group28projectjpa_21_11.core.validation.IsAlreadyExistException;
import org.group28projectjpa_21_11.core.validation.NotFoundException;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerResponseDTO;
import org.group28projectjpa_21_11.entyty.Manager;
import org.group28projectjpa_21_11.entyty.Role;
import org.group28projectjpa_21_11.repository.ManagerRepository;
import org.group28projectjpa_21_11.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerServices {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;

    // получить список всех пользователей

    public List<ManagerResponseDTO> findAllManagers() {
        return repository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    //найти пользователя по email
    public ManagerResponseDTO findByManagerEmail(String email){
        Manager manager =repository.findByEmail(email).orElseThrow(() -> new NotFoundException("Manager not found with email: " + email));
        return converter.toDto(manager);
    }

    public ManagerResponseDTO findByManagerName(String name){
        Manager manager =repository.findByManagerName(name).orElseThrow(() -> new NotFoundException("Manager not found with email: " + name));
        return converter.toDto(manager);
    }

    // Создать нового пользователя

    public ManagerCreateResponseDTO createManager(ManagerCreateRequestDTO requestDTO) {
        if (repository.findByManagerName(requestDTO.getManagerName()).isEmpty()) {
            Manager newManager = converter.fromDto(requestDTO);

            Optional<Role> defaultRole=roleRepository.findByName("USER");
            if (defaultRole.isPresent()){
                newManager.setRole(defaultRole.get());
            }else {
                throw new NotFoundException("Role 'User' ndt found");
            }

            newManager.setCreateManagerDate(LocalDateTime.now());
            newManager.setLastUpdate(LocalDateTime.now());


            Manager savedManager = repository.save(newManager);
            return converter.toCreateDto(savedManager);
        } else {
            throw new IsAlreadyExistException("Manager with name " + requestDTO.getManagerName() + " is already exist.");
        }
    }


    public boolean deleteManager(Integer id) {
        Manager manager = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager with ID: " + id + " is not found!"));
        repository.delete(manager);
        return true;
    }

}