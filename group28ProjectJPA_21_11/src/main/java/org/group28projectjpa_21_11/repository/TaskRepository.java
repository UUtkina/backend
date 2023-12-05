package org.group28projectjpa_21_11.repository;

;
import org.group28projectjpa_21_11.entyty.Manager;
import org.group28projectjpa_21_11.entyty.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTaskName(String taskName);

    List<Task> findByManager(Manager manager);

}