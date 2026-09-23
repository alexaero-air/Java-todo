package Main;

public class CombatDrone extends Drone{

    public CombatDrone(String purpose, int energy, int strength) {
        super(purpose, energy);
        this.strength = strength;
    }
}
