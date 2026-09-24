package Main;

public interface Delivery {
    String name(); // Возвращает название способа доставкиж;

    boolean accepts(double weight); // Получаем вес и спрашиваем подходит/не подходит данный способ
                                    // возвращается true/false

    double price(double weight, double orderTotal); // получает вес и стоимость товаров
                                                    // возвращает цену доставки

}
