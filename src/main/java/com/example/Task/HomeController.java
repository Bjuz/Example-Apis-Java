package com.example.Task;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.Task.TaskList;



@RestController //ready for use by Spring MVC to handle web requests
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class HomeController {
	private final AtomicLong counter = new AtomicLong();

	private final TaskList taskList = new TaskList();
	LocalDate currentDate = LocalDate.now();

	// Define a date formatter
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	// Format the LocalDate as a String
	String formattedDate = currentDate.format(formatter);

	@GetMapping("/")//redirect in index
	public String index() {
			return "Get starting using our system";
	}

	@GetMapping("/GetTasks")
	public List<Task> greeting() {
		return taskList.getTasks();
	}

	@GetMapping("/GetPercentTask/{State}")
	public int PercentTask(@PathVariable String State) {
		return taskList.countTasksState(State) ;
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

		taskList.getTasks().add(newTask); // Add the task in TaskList

		return newTask;
	}
	@PatchMapping("/UpdateTask")
	public Task updateTaskState( @RequestBody Task task) {
		return taskList.UpdateTask(task); // Implement this method to find the task by ID
	}

}