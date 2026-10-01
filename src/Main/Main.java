package Main;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("requests.txt");
        RequestJournal journal = new RequestJournal(path);
        System.out.println("Журнал находится: " + path.toAbsolutePath());

        try(Scanner scanner = new Scanner(System.in)) {
            while (true){
                System.out.println();
                System.out.println("1 - Добавить заявку");
                System.out.println("2 - Просмотреть журнал");
                System.out.println("3 - Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine().strip();
                try {
                    switch (choice){
                        case "1":
                            addRequest(scanner, journal);
                            break;
                        case "2":
                            showJournal();
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор: " + choice + ". Нажмите 1, 2 или 3");
                    }
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("Не удалось выполнить операцию");
                    System.out.println("Проверьте путь к файлу");
                }
            }
        }
    }
    private static void addRequest(){

    }
    private static void showJournal(){

    }
}
