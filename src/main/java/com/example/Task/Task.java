package com.example.Task;

public class Task {
    private long id;
    private String title;
    private String description;
    private String assignTo;
    private String creationDate;
    private String state;

    public Task(long id, String title, String description, String assignTo, String creationDate, String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignTo = assignTo;
        this.creationDate = creationDate;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}





