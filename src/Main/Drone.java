package Main;

public class Drone {
    protected String purpose;
    protected int energy;
    protected int strength;
    protected int details;

    protected Drone(String purpose, int energy) {
        this.purpose = purpose;
        this.energy = energy;
    }

    private int getEnergy() {
        return energy;
    }

    private void setEnergy(int energy) {
        this.energy = energy;
    }

    public void charge(int energy){
        int currentEP = this.getEnergy();
        int newEP = energy + currentEP;
        this.setEnergy(newEP);
    }

    public void attack(Base target){
        System.out.println("Unable to attack.");
    }

    public void repair(Base target){
        System.out.println("Unable to repair.");
    }
}
