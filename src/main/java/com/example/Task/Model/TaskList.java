package com.example.Task.Model;
import com.example.Task.Model.Task;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;


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
        return null;
    }

    public Task getTaskById(String ID) {
        long Identify = Long.parseLong(ID);
        for (Task task : tasks) {
            if (task.getId() == Identify) {
                return task;
            }
        }
        return null;
    }

    public List<String> getListStates(){
        List<String> StatesList = new ArrayList<>();
        for (Task task : tasks) {
            if (!StatesList.contains(task.getState())) {
                StatesList.add(task.getState());
            }
        }
        return  StatesList;
    }



}
