package Main;


import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            ToDoFrame window = new ToDoFrame();
            window.setVisible(true);
        });
    }
}