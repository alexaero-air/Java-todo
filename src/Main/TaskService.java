package Main;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public Task addTask (String title){
        Task task = new Task(title);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void completeTask(Task task){
        task.markCompleted();
    }
    public void deleteTask(Task task){
        tasks.remove(task);
    }
}