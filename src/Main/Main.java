package Main;

import javax.swing.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args){

        Path dataFile = Path.of(
                System.getProperty("user.home"),
                "Downloads",
                "todolist.txt"
        );

        TaskStorage storage = new TaskStorage(dataFile);

        SwingUtilities.invokeLater(() ->{
            ToDoFrame window = new ToDoFrame(storage);
            window.setVisible(true);
        }); 
    }
}