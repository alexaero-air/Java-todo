package Main;

public class Main {
    public static void main(String[] args) {
        RepairService service = new RepairService();

        PriceRule standard = hours -> 500 + hours * 600;
        PriceRule express = hours -> 500 + hours * 900;

        System.out.println(
                "Обычный: " +  service.quote(2, standard)
                + "\nЭкспресс: " + service.quote(2,express)
                );
    }
}
