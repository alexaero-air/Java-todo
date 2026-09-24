package Main;

public class Courier implements Delivery{
    @Override
    public String name() {
        return "Курьер";
    }

    @Override
    public boolean accepts(double weight) {
        return weight <= 20;
    }

    @Override
    public double price(double weight, double orderTotal) {
        return 300 + 20 * weight;
    }
}
