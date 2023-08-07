package com.example.Task;
import java.util.ArrayList;
import java.util.List;
public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task addTask(Task newTask){
        tasks.add(newTask);
        return newTask;
    }


    public int countTasksState(String state) {
        if(tasks.isEmpty()){
            return 0;
        }
        int count = 0;
        for (Task task : tasks) {
            if (task.getState().equals(state)) {
                count++;
            }
        }
        return count*100/tasks.size();
    }
    public Task UpdateTask(Task NewTask ) {
        for (Task task : tasks) {
            if (task.getId() == NewTask.getId()) {
                task.setTitle(NewTask.getTitle());
                task.setDescription(NewTask.getDescription());
                task.setAssignTo(NewTask.getAssignTo());
                task.setCreationDate(NewTask.getCreationDate());
                task.setState(NewTask.getState());
                return task;
            }
        }
        return new Task();
    }
}
