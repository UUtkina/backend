package org.group28projectjpa_21_11.controllers;


import org.group28projectjpa_21_11.core.services.ManagerServices;
import lombok.AllArgsConstructor;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MagareControllers {
    private final ManagerServices managerServices;
    /*1. Получение списка всех пользователей
        Method: GET
       URL:/api/admin/managers
    2. Получение пользователя по email
       Method: GET
      URL:/api/admin/managers/{email}
    3. Удалить пользователя по ID
       Method: DELETE
       URL:/api/admin/manager/{id}
    */


    @PostMapping("/")
    public ManagerCreateResponseDTO addUser(@RequestBody ManagerCreateRequestDTO managerCreateRequestDTO) {
        return managerServices.createManager(managerCreateRequestDTO);
    }

    @GetMapping("/admin/managers/{email}")
    public ResponseEntity<ManagerResponseDTO> findMagersByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(managerServices.findByManagerEmail(email), HttpStatus.FOUND);
    }

    @GetMapping("/admin/managers")
    public List<ManagerResponseDTO> findAllUsers() {
        return managerServices.findAllManagers();
    }

    @DeleteMapping("/admin/manager/{id}")
    public boolean deleteManagerById(@PathVariable Integer id) {
        return managerServices.deleteManager(id);
    }

}


