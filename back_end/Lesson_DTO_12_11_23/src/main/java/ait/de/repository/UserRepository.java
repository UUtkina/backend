package ait.de.repository;

import ait.de.entety.ToDo;
import ait.de.entety.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
   User save(User entity);
     List<User> findAll();

    Optional<User>  findById (Integer id);

  }
