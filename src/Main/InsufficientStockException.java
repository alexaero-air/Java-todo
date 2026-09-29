package Main;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(int request, int available){
        super("Недостаточно ноутбуков. Запрошено: " + request
                + " шт., доступно: " + available + " шт.");
    }
}
