package Main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String SEPARATOR ="\t";
    private final Path path;

    public TaskStorage (Path path){
        this.path = path;
    }

    public List<Task> load (){
        List<Task> tasks = new ArrayList<>();

        if(!Files.exists(path)){
            return tasks; //первый запуск - журнала ещё нет
        }
        try{
            for(String line : Files.readAllLines(path, StandardCharsets.UTF_8)){
                if(line.isBlank()) continue;
                String [] parts = line.split(SEPARATOR, 2);
                if(parts.length !=2) continue;

                boolean completed = Boolean.parseBoolean(parts[0]);
                String title = parts[1];

            }
        }
        catch (IOException e){
            System.out.println("Не удалось сохранить задачи: "+e.getMessage());
        }
        return tasks;
    }
    public void save(List<Task> tasks) throws IOException{
        StringBuilder sb = new StringBuilder();

        for(Task task : tasks){
            String ifcompleted;

            if (task.isCompleted()) ifcompleted = "Выполненная задача: ";
            else ifcompleted = "Невыполненная задача: ";
            sb.append(ifcompleted)
                    .append(SEPARATOR)
                    .append(task.getTitle())
                    .append(System.lineSeparator());
        }

        Files.writeString(
                path,
                sb.toString(), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE

        );
    }


}
