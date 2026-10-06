package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Анна");
        names.add("Борис");
        names.add("Анна");
        names.set(1,"Николай");
//        names.remove("Анна");
//        names.remove("Анна");
//        names.remove(0);

        System.out.println(names);
        System.out.println(names.get(0));
        System.out.println(names.size());

        for (String name : names){
            System.out.println(name);
        }
        if (names.contains("Борис")){
            System.out.println("Борис есть в списке");
        } else {
            System.out.println("Бориса нет в списке");
        }
    }
}
