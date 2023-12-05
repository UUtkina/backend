package org.group28projectjpa_21_11.core.services;

import lombok.AllArgsConstructor;

import org.group28projectjpa_21_11.core.utils.TaskConverter;
import org.group28projectjpa_21_11.core.validation.IsAlreadyExistException;
import org.group28projectjpa_21_11.core.validation.NotFoundException;
import org.group28projectjpa_21_11.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa_21_11.dto.manager.ManagerResponseDTO;
import org.group28projectjpa_21_11.dto.task.*;
import org.group28projectjpa_21_11.entyty.Task;
import org.group28projectjpa_21_11.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServices {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    // получить список всех задач

    public List<TaskResponseDTO> findAllTask() {
        return taskRepository.findAll().stream()
                .map(taskConverter::toDto)
                .toList();
    }

    public List<TaskResponseAllDTO> findAllTaskRoun() {
        return taskRepository.findAll().stream()
                .map(task -> {
                    TaskResponseAllDTO taskResponseDTO = taskConverter.toAllDto(task);
                    taskResponseDTO.setManagerCreateResponseDTO(
                            new ManagerCreateResponseDTO(
                                    task.getManager().getId(),
                                    task.getManager().getManagerName(),
                                    task.getManager().getCreateManagerDate(),
                                    task.getManager().getLastUpdate()
                            )
                    );
                    return taskResponseDTO;
                })
                .toList();
    }




    //найти задачу по id
    public TaskResponseDTO findTaskById(Integer id){
        Task task =taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found with id: " + id));
        return taskConverter.toDto(task);
    }

    // Создать новую задачу

    public TaskCreateOrUpdateResponseDTO createTask(TaskCreateRequestDTO requestDTO) {
        if (taskRepository.findByTaskName(requestDTO.getTaskName()).isEmpty()) {
            Task newTask = taskConverter.fromCreateRequest(requestDTO);
            newTask = taskRepository.save(newTask);
            return taskConverter.toCreateDto(newTask);
        } else {
            throw new IsAlreadyExistException("Task with name " + requestDTO.getTaskName() + " is already exist!");
        }
    }

    public TaskCreateOrUpdateResponseDTO updateTask(Integer id, TaskUpdateRequestDTO updateRequestDTO) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task taskForUpdate = taskOptional.get();
            if(updateRequestDTO.getTaskName()!=null){taskForUpdate.setTaskName(updateRequestDTO.getTaskName());}
            if(updateRequestDTO.getDescription()!=null){taskForUpdate.setDescription(updateRequestDTO.getDescription());}
            Task updateTask = taskRepository.save(taskForUpdate);
            return taskConverter.toCreateDto(taskForUpdate);
        } else {
            throw new NotFoundException("Task with id " + id + " not found");
        }
    }

    public boolean deleteTask(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task with ID: " + id + " is not found!"));
        taskRepository.delete(task);
        return true;
    }

}