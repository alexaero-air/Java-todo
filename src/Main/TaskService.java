package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final TaskStorage storage;

    public TaskService (TaskStorage storage){
        this.storage = storage;
        this.tasks.addAll(storage.load()); // загрузка при старте
    }


    public Task addTask(String title) throws IOException {
        Task task = new Task(title);
        tasks.add(task);
        storage.save(tasks);
        return task;
    }

    public void completeTask(Task task) throws IOException{
        task.markCompleted();
        storage.save(tasks);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }
}
