package com.springapi.SpringApi.service;

import com.springapi.SpringApi.model.Task;
import com.springapi.SpringApi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return taskRepository.existsById(id);
    }

    public Task getTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
