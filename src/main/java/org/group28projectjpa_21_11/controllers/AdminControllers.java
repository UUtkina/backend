package org.group28projectjpa_21_11.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.group28projectjpa_21_11.core.services.ManagerServices;
import org.group28projectjpa_21_11.core.services.TaskServices;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerResponseDTO;
import org.group28projectjpa_21_11.entyty.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminControllers {
    private final ManagerServices managerServices;
    private final TaskServices taskServices;

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


    @PostMapping("/managers")
    public ResponseEntity<ManagerCreateResponseDTO> createNewManager(@Valid @RequestBody ManagerCreateRequestDTO request) {
        return new ResponseEntity<>(managerServices.createManager(request), HttpStatus.CREATED);
    }

    @GetMapping("/managers")
    public ResponseEntity<List<ManagerResponseDTO>> findAllManager() {
        return new ResponseEntity<>(managerServices.findAllManagers(), HttpStatus.OK);
    }

    @GetMapping("/managers/{email}")
    public ResponseEntity<ManagerResponseDTO> findManagerByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(managerServices.findByManagerEmail(email), HttpStatus.OK);
    }

    @GetMapping("/managers/{managerName}")
    public ResponseEntity<ManagerResponseDTO> findManagerByManagerName(@PathVariable("managerName") String managerName) {
        return new ResponseEntity<>(managerServices.findByManagerName(managerName), HttpStatus.OK);
    }

    @DeleteMapping("/{managers_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManagerById(@PathVariable("manager_id") Integer managerId){
        managerServices.deleteManager(managerId);
    }

   /* @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAllTasks() {
        return new ResponseEntity<>(taskServices.findAllTaskRoun(), HttpStatus.OK);
    }*/
}



