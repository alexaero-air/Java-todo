package Main;

public class SupplyDrone extends Drone{

    public SupplyDrone(String purpose, int energy, int details) {
        super(purpose, energy);
        this.details = details;
    }
}
