package Main;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Доступные способы доставки
        ArrayList<Delivery> options = new ArrayList<>();
        options.add(new PickupPoint());
        options.add(new Courier());

        //заказы, которые нужно обработать в массиве
        Order [] orders = {
                new Order(2,1000),
                new Order(8,3500),
                new Order(15,2000),
                new Order(25,5000)
        };

        for (int i=0; i < orders.length; i++){
            Order order = orders[i];
            // для нового заказа начинаем поиск заново
            Delivery best = null;
            double bestPrice = Double.MAX_VALUE;
            System.out.println("Заказ № " + (i+1));
            for (Delivery option : options){
                //Сначала проверяем допустимый вес
                if (!option.accepts(order.getWeight())){
                    System.out.println(option.name() + ": недоступно, превышен вес");
                    continue;
                }

                //рассчитаем цену доступного способа

                double price = option.price(order.getWeight(), order.getTotal());
                System.out.println(option.name() + ": " + price + " руб.");

                //запоминаем более доступный или более дешевый
                if (best == null || price < bestPrice){
                    best = option;
                    bestPrice = price;
                }
            }

            //показывем результат
            if (best == null){
                System.out.println("Нет доступных способов доставки");
            } else {
                System.out.println(
                        "Выбран: " + best.name()
                        + ", " + bestPrice + " руб."
                );
            }



        }

    }
}
