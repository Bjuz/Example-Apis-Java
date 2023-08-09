package com.example.Task.Model;

import io.swagger.annotations.ApiModelProperty;

public class States {
    @ApiModelProperty(example = "New")
    private String State;

    @ApiModelProperty(example = "3")
    private long Count;

    public States(String state, long count) {
        State = state;
        Count = count;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public long getCount() {
        return Count;
    }

    public void setCount(long count) {
        Count = count;
    }
}
