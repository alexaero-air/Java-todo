package Main;

public class Order {
    private double weight;
    private double total;

    public Order(double weight, double total) {
        this.weight = weight;
        this.total = total;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotal() {
        return total;
    }
}
