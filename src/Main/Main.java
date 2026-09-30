package Main;

public class Main {
    public static void main(String[] args) {
        new A().start(); // Короткая запись A threadA = new A(); threadA.start();
        new B().start();
        // JVM сама выбирает какой поток активен в настоящее время
    }
}
