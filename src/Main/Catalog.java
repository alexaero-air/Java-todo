package Main;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Catalog {
    public int report(List<Product> products,
                      Predicate<Product> condition,
                      Consumer<Product> action){
        int count = 0;
        for (Product product : products){
            if (condition.test(product)){
                action.accept(product);
                count++;
            }
        }
        return count;
    }
}
