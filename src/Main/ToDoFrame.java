package Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ToDoFrame extends JFrame {
    private final TaskService service = new TaskService();
    private final TaskStorage storage;
    private final JTextField titleField = new JTextField();
    private final DefaultListModel <Task> listModel = new DefaultListModel<>();

    private final JList<Task> taskList = new JList<>(listModel);

    public ToDoFrame(TaskStorage storage){
        super("МОИ ЗАДАЧИ");
        this.storage = storage;

        for (Task task : storage.load()){
            service.getTasks().add(task);
        }
        refreshList();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 360);//начальный размер окна
        setLocationRelativeTo(null); //центрует окно на экране

        taskList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JPanel content = new JPanel(new BorderLayout(10,10));

        content.setBorder(
                BorderFactory.createEmptyBorder(12,12,12,12)
        );

        content.add(titleField, BorderLayout.NORTH);

        content.add(
                new JScrollPane(taskList),BorderLayout.CENTER
        );

        JButton addButton = new JButton("ДОБАВИТЬ");
        JButton completeButton = new JButton("ВЫПОЛНЕНО");
        JButton deleteButton = new JButton("УДАЛИТЬ");

        JPanel buttons = new JPanel(new FlowLayout());

        buttons.add(addButton);
        buttons.add(completeButton);
        buttons.add(deleteButton);


        content.add(buttons, BorderLayout.SOUTH);
        setContentPane(content);

        addButton.addActionListener(event -> handleAdd()); //связывает с методом handleAdd
        titleField.addActionListener(event -> handleAdd());

        completeButton.addActionListener(event -> handleComplete()); //связывает с методом handleAdd
        titleField.addActionListener(event -> handleComplete());

        deleteButton.addActionListener(event -> handleDelete()); //связывает с методом handleAdd
        titleField.addActionListener(event -> handleDelete());


    }

    private void refreshList(){
        listModel.clear();
        for(Task task : service.getTasks()){
            listModel.addElement(task);
        }
    }

    private void saveFile(){
        try {
            storage.save(service.getTasks());
        } catch (IOException e){
            System.out.println("Ошибка записи файла");
        }
    }

    private void handleAdd(){
        try{
            Task task = service.addTask(titleField.getText());
            refreshList();
            saveFile();

            taskList.setSelectedValue(task,true);

            titleField.setText("");
            titleField.requestFocusInWindow();
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"ошибка ввода",JOptionPane.WARNING_MESSAGE);
        }


    };

    private void handleComplete(){
        Task task = taskList.getSelectedValue();
        if (task == null){
            JOptionPane.showMessageDialog(this,"СНАЧАЛО ВЫПОЛНИ ЗАДАЧУ");
            return;
        }
        service.completeTask(task);
        refreshList();
        saveFile();
        taskList.setSelectedValue(task, true);
    }

    private void handleDelete(){
        Task task = taskList.getSelectedValue();

        if(task ==null){
            JOptionPane.showMessageDialog(this,"СНАЧАЛА ВЫБЕРИ ЗАДАЧУ");
            return;
        }
        service.deleteTask(task);
        refreshList();
        saveFile();
        taskList.setSelectedValue(task, true);
        }
    }

