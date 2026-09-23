package Main;

public class SupplyDrone extends Drone{

    public SupplyDrone(String purpose, int energy, int details) {
        super(purpose, energy);
        this.details = details;
    }
    public void repair(Base target){
        if (details >= 1 && energy >= 8){
            this.details -= 1;
            this.energy -= 8;
            int currentHP = target.getBaseHP();
            if (100 - currentHP + 12 > 100){
                target.setBaseHP(100);
            } else {
                int newHP = 12 + currentHP;
                target.setBaseHP(newHP);
                System.out.println("Repair success! Base HP is " + newHP);
            }
        } else {
            System.out.println("Repair failed! Not enough resources.");
        }
    }
}
