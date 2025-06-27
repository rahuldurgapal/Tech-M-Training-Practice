package com.springapi.SpringApi.repository;

import com.springapi.SpringApi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

  public Task findByTitle(String title);
}
