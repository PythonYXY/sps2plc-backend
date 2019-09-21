package sps2plc.tasks;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/task")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        return taskService.getTask(task);
    }

    @GetMapping("/finished/{id}")
    public Task getFinishedTask(@PathVariable("id") Long id) {
        return taskService.getFinishedTask(id);
    }
}
