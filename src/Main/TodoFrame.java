package Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TodoFrame extends JFrame {

    private final TaskService service;
    private final JTextField titleField = new JTextField();
    private final DefaultListModel<Task> listModel = new DefaultListModel<>();
    private final JList<Task> taskList = new JList<>(listModel);

    public TodoFrame(TaskService service){
        super("Мои задачи");
        this.service = service;

        // Настройка главного окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Инициализация списка задач на экране
        for (Task task : service.getTasks()) {
            listModel.addElement(task);
        }

        // Панель ввода (Верхняя часть)
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        JButton addButton = new JButton("Добавить");
        inputPanel.add(titleField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.NORTH);

        // Список задач (Центральная часть)
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Список дел"));
        add(scrollPane, BorderLayout.CENTER);

        // Панель действий (Нижняя часть)
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton completeButton = new JButton("Выполнить");
        JButton deleteButton = new JButton("Удалить");
        actionPanel.add(completeButton);
        actionPanel.add(deleteButton);
        add(actionPanel, BorderLayout.SOUTH);

        // Логика кнопки "Добавить"
        addButton.addActionListener(e -> {
            String text = titleField.getText();
            if (!text.isBlank()) {
                try {
                    Task newTask = service.addTask(text);
                    listModel.addElement(newTask);
                    titleField.setText("");
                } catch (IOException ex) {
                    showError("Ошибка сохранения задачи");
                }
            }
        });

        // Логика кнопки "Выполнить"
        completeButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null && !selectedTask.isCompleted()) {
                try {
                    service.completeTask(selectedTask);
                    taskList.repaint(); // Перерисовываем список, чтобы обновился статус [✓]
                } catch (IOException ex) {
                    showError("Ошибка обновления статуса задачи");
                }
            }
        });

        // Логика кнопки "Удалить"
        deleteButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null) {
                try {
                    service.deleteTask(selectedTask);
                    listModel.removeElement(selectedTask);
                } catch (IOException ex) {
                    showError("Ошибка удаления задачи");
                }
            }
        });
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
