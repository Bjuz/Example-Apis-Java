package com.example.Task.Model;

import io.swagger.annotations.ApiModelProperty;

public class Task {
    @ApiModelProperty(example = "1")
    private long id;

    @ApiModelProperty(example = "Sample Task")
    private String title;

    @ApiModelProperty(example = "This is a sample task.")
    private String description;

    @ApiModelProperty(example = "John Doe")
    private String assignTo;

    @ApiModelProperty(example = "2023-08-08")
    private String creationDate;

    @ApiModelProperty(example = "New")
    private String state;

    public Task(long id, String title, String description, String assignTo, String creationDate, String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignTo = assignTo;
        this.creationDate = creationDate;
        this.state = state;
    }

    public Task() {
        this.id = 1;
        this.title = "1";
        this.description = "1";
        this.assignTo = "1";
        this.creationDate = "1";
        this.state = "1";
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





