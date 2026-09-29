package Main;

public class Warehouse {
    private final String productName;
    private int stock;

    public Warehouse(String productName, int stock) {
        if (stock < 0){
            throw new IllegalArgumentException("Начальный остаток не может быть отрицательным");
        }
        this.productName = productName;
        this.stock = stock;
    }

    public void issue(int quantity) throws InsufficientStockException{
        if (quantity <= 0){
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }
        if (quantity > stock){
            throw new InsufficientStockException(quantity, stock);
        }
        stock -= quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }
}
