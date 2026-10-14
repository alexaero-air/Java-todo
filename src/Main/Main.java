package Main;

import javax.swing.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path dataFile = Path.of(
                System.getProperty("user.home"),
                ".todoapp-tasks.txt"
                );

        TaskStorage storage new TaskStorage()

        SwingUtilities.invokeLater(() -> {
            TodoFrame window = new TodoFrame();

        });
    }
}
