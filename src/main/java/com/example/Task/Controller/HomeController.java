package com.example.Task.Controller;

import com.example.Task.Task;
import com.example.Task.TaskList;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class HomeController {
	private final AtomicLong counter = new AtomicLong();
	private final TaskList taskList = new TaskList();

	@ApiOperation(
			value = "Get the welcome message"
	)
	@GetMapping("/")
	public String index() {
		return "Get starting using our system";
	}

    @ApiOperation(
            value = "Get the list of the task that is in the list"
    )
	@GetMapping("/GetTasks")
	public List<Task> getTasks() {
		return taskList.getTasks();
	}

	@ApiOperation(
			value = "Get the percent of tasks with the same state"
	)
	@GetMapping("/GetPercentTask/{State}")
	public int getPercentTask(@PathVariable String State) {
		return taskList.countTasksState(State);
	}

	@ApiOperation(
			value = "Create tasks and attached to the list "
	)
	@PostMapping("/CreateTask")
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		Task newTask = new Task(
				counter.incrementAndGet(),
				task.getTitle(),
				task.getDescription(),
				task.getAssignTo(),
				LocalDate.now().toString(),
				"New"
		);

		taskList.addTask(newTask);

		return newTask;
	}

	@ApiOperation(
			value = "Update  task based of the id"
	)
	@PatchMapping("/UpdateTask")
	public Task updateTaskState(@RequestBody Task task) {
		return taskList.UpdateTask(task);
	}
}
