package Main;

public class CombatDrone extends Drone{

    public CombatDrone(String purpose, int energy, int strength) {
        super(purpose, energy);
        this.strength = strength;
    }

    @Override
    public void attack(Base target){
        if (energy >= 15){
            this.energy -= 15;
            int currentHP = target.getBaseHP();
            int newHP = currentHP - this.strength;
            if (newHP > 0) {
                System.out.println("Base got " + this.strength + " damage. Current base HP is " + newHP);
            } else {
                System.out.println("Base got " + this.strength + " damage. Base has been destroyed.");
            }
        }
    }
}
