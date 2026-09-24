package Main;

public class PickupPoint implements Delivery{

    @Override
    public String name() { // метод возвращает название способа доставки
        return "Пункт выдачи";
    }

    @Override
    public boolean accepts(double weight) { // проверка веса
        return weight <= 10;
    }

    @Override
    public double price(double weight, double orderTotal) { // возвращает стоимость доставки
        if (orderTotal >= 3000){
            return 0; // если стоимость заказа >= 3000, доставка стоит 0
        }
        return 150; // если меньше, доставка стоит 150
    }
}
