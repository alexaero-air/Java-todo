package Main;

import javax.swing.*;

public class TodoFrame extends JFrame {

    private final TaskService service = new TaskService();

    private final JTextField titleField = new JTextField();

    private final DefaultListModel<Task> listModel =
            new DefaultListModel<>();

    private final JList<Task> taskList = new JList<>(listModel);


    public TodoFrame(){
        super("Мои задачи");
    }


}
