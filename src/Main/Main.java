package Main;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("Ноутбуки", 29);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Товар: " + warehouse.getProductName());
        System.out.println("На складе: " + warehouse.getStock());

        while (true){
            System.out.print("Количество для выдачи или \"выход\": ");

            // Завершаем работу, если поток ввода закончился
            if (!scanner.hasNextLine()){
                break;
            }

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("выход")){
                System.out.println("Выход...");
                break;
            }

            try {
                int quality = Integer.parseInt(input);
                warehouse.issue(quality);
                System.out.println("Выдано: " + quality + " шт.");
            } catch (NumberFormatException e) {
                System.out.println("Не удалось распознать количество. Введите целое число, например 5");
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Остаток: " + warehouse.getStock() + " шт.");
            System.out.println();
        }
        scanner.close();
        System.out.println("Работа завершена. Остаток: " + warehouse.getStock());
    }
}
