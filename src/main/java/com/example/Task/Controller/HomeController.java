package com.example.Task.Controller;

import com.example.Task.Task;
import com.example.Task.TaskList;
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

	@GetMapping("/")
	public String index() {
		return "Get starting using our system";
	}

	@GetMapping("/GetTasks")
	public List<Task> getTasks() {
		return taskList.getTasks();
	}

	@GetMapping("/GetPercentTask/{State}")
	public int getPercentTask(@PathVariable String State) {
		return taskList.countTasksState(State);
	}

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

	@PatchMapping("/UpdateTask")
	public Task updateTaskState(@RequestBody Task task) {
		return taskList.UpdateTask(task);
	}
}
