package ait.de.repository;

import ait.de.entety.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    ToDo save(ToDo entity);
     List<ToDo> findAll();

    Optional<ToDo>  findById (Integer id);

   List<ToDo> findByUserId(Integer userId);

 public boolean delete(Integer id);
 }

