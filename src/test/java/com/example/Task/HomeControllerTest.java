package com.example.Task;

import com.example.Task.Controller.HomeController;
import com.example.Task.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collections;
import static org.mockito.Mockito.when;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskList taskList;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testGetTasks() throws Exception {
        when(taskList.getTasks()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/_apis/GetTasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testGetPercentTask() throws Exception {
        String state = "New";
        when(taskList.countTasksState(state)).thenReturn(2);

        mockMvc.perform(MockMvcRequestBuilders.get("/_apis/GetPercentTask/{State}", state)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("0"));
    }

    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task(1, "Test Task", "Description", "Assignee", "2023-08-06", "New");
        when(taskList.addTask(task)).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/_apis/CreateTask")
                        .content(asJsonString(task))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Task"));
    }

    @Test
    public void testUpdateTask() throws Exception {
        Task task = new Task(1, "Test Task", "Description", "Assignee", "2023-08-06", "New");
        Task task2 = new Task(1, "Updated Task", "Updated Description", "Updated Assignee", "2023-08-06", "Updated");

        when(taskList.addTask(task)).thenReturn(task);
        when(taskList.UpdateTask(task2)).thenReturn(task);


        mockMvc.perform(MockMvcRequestBuilders.post("/_apis/CreateTask")
                        .content(asJsonString(task))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Task"));

        mockMvc.perform(MockMvcRequestBuilders.patch("/_apis/UpdateTask")
                        .content(asJsonString(task2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Task"));
    }

    // Helper method to convert object to JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}