package com.springapi.SpringApi.controller;

import com.springapi.SpringApi.model.Task;
import com.springapi.SpringApi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if(tasks.size()==0) {
           return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/task/{title}")
    public Task getTaskByTitle(@PathVariable("title") String title) {
        return taskService.getTaskByTitle(title);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id) {
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Fetched-By","TaskController");
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(task.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable("id") int id, @RequestBody Task task) {
//        Task task1 = taskService.getTaskById(id).get();
//        task1.setTitle(task.getTitle());
//        task1.setDescription(task.getDescription());
//        task1.setStatus(task.getStatus());

        task.setId(id);


        return taskService.saveTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
    }
}
