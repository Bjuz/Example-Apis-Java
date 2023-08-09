package com.example.Task.Controller;

import com.example.Task.Model.Task;
import com.example.Task.Model.TaskList;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HomeController {
	private final AtomicLong counter = new AtomicLong();
	private final TaskList taskList = new TaskList();
	@Hidden
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/index.html");
	}
	@Hidden
	@GetMapping("/viewTasks")
	public ModelAndView viewTasks() {
		return new ModelAndView("redirect:/viewTasks.html");
	}
	@Hidden
	@GetMapping("/updateTask")
	public ModelAndView updateTask() {
		return new ModelAndView("redirect:/updateTask.html");
	}


	@Operation(summary = "Get the list of the tasks in the list")
	@GetMapping("/_apis/GetTasks")
	public List<Task> getTasks() {
		try {
			return taskList.getTasks();
		} catch (Exception ex) {
			// Handle and log the exception
			return null; // Indicate an error state
		}

	}



	@Operation(summary = "Get the percent of tasks with the same state")
	@GetMapping("/_apis/GetPercentTask/{State}")
	public int getPercentTask(@PathVariable String State) {
		try {
			return taskList.countTasksState(State);
		} catch (Exception ex) {
			// Handle and log the exception
			return -1; // Indicate an error state
		}

	}

	@Operation(summary = "Get a task by ID")
	@GetMapping("/_apis/GetTaskByID/{ID}")
	public Task GetTaskByID(@PathVariable String ID) {
		try {
			return  taskList.getTaskById(ID);
		} catch (Exception ex) {
			// Handle and log the exception
			return null; // Indicate an error state
		}

	}

	@Operation(summary = "Create tasks and attach them to the list")
	@PostMapping("/_apis/CreateTask")
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		Task newTask = new Task(
				task.getId(),
				task.getTitle(),
				task.getDescription(),
				task.getAssignTo(),
				LocalDate.now().toString(),
				"New"
		);
		try {
			taskList.addTask(newTask);
		} catch (Exception ex) {
			// Handle and log the exception
			return null; // Indicate an error state
		}


		return newTask;
	}

	@Operation(summary = "Update a task based on the ID")
	@PatchMapping("/_apis/UpdateTask")
	public Task updateTaskState(@RequestBody Task task) {
		try {
			return taskList.UpdateTask(task);
		} catch (Exception ex) {
			// Handle and log the exception
			return null; // Indicate an error state
		}

	}


}
