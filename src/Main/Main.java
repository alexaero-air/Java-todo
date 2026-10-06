package Main;

import com.sun.net.httpserver.Request;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> clients = new HashSet<>();
        System.out.println(clients.add("C101"));
        System.out.println(clients.add("C102"));
        System.out.println(clients.add("C101"));
        System.out.println(clients.add("C103"));

        System.out.println(clients.size());
        System.out.println(clients);
    }
}
