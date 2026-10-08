package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Стул",4000,3));
        products.add(new Product("Стол",9000,0));
        products.add(new Product("Лампа",1500,8));
        products.add(new Product("Полка",3500,2));

        int budget = 4000;
        Predicate<Product> available = product -> product.getStock() > 0
                && product.getPrice() <= budget;

        Consumer<Product> printPrice = product -> System.out.println(product.getName()
                + ": " + product.getPrice() + " руб."
        );

        Catalog catalog = new Catalog();
        System.out.println("В наличии до 4000 руб включительно");

        int selected = catalog.report(products, available, printPrice);

        System.out.println("Найдено: " + selected);
        System.out.println("\nНужно пополнить:");

        int lowStock = catalog.report(products,
                product -> product.getStock() < 3,
                product -> System.out.println(
                        product.getName()
                        + ": остаток "
                        + product.getStock() + " шт.")
        );

    }
}
