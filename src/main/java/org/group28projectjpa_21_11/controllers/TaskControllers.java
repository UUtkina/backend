package org.group28projectjpa_21_11.controllers;

import org.group28projectjpa_21_11.core.services.TaskServices;
import lombok.AllArgsConstructor;
import org.group28projectjpa_21_11.dto.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TaskControllers {
    private final TaskServices services;
     /*
    1. Создать новую задачу
Method: POST
URL: /api/task

    2. Получение списка всех задач
Method: GET
URL: /api/tasks

   3. Получение задачи по ID
Method: GET
URL: /api/tasks/{id}

4. Редактировать задачу
Method:PUT
URL:/api/tasks/{id}

5. Получить полный развернутый список всех задач

Method: GET
URL:/api/admin/tasks

6. Удалить задачу
Method:Delete
URL:/api/tasks/{id}

     */


    @PostMapping("/task")
    public TaskCreateOrUpdateResponseDTO responseDTO(@RequestBody TaskCreateRequestDTO requestDTO) {
        return services.createTask(requestDTO);
    }

    @GetMapping("/tasks")
    public List<TaskResponseDTO> findAllTask() {
        return services.findAllTask();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDTO> findTaskById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(services.findTaskById(id), HttpStatus.FOUND);
    }

    @PutMapping("/tasks/{id}")
    public TaskCreateOrUpdateResponseDTO updateTask(@PathVariable("id") Integer id, @RequestBody TaskUpdateRequestDTO updateRequest) {
        return services.updateTask(id, updateRequest);
    }


    @GetMapping("/admin/tasks")
    public List<TaskResponseAllDTO> findAllTaskRoun() {
        return services.findAllTaskRoun();
    }


    @DeleteMapping("/tasks/{id}")
    public boolean deleteTaskById(@RequestParam Integer id) {
        return services.deleteTask(id);
    }
}
