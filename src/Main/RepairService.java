package Main;

public class RepairService {
    public int quote (int hours, PriceRule rule){
        if (hours < 1 || hours > 24){
            throw new IllegalArgumentException("Допустимо от 1 до 24 часов");
        }
        return rule.calculate(hours);
    }
}
