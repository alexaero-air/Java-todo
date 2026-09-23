package Main;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Base base = new Base(100);


        Drone c1 = new CombatDrone("combat",20,14);
        Drone c2 = new CombatDrone("combat",10,11);
        Drone r1 = new SupplyDrone("supply",24,14);

        c1.attack(base);
        r1.repair(base);
        c2.attack(base);
        r1.charge(10);
        c1.attack(base);
        System.out.println("Final base HP is " + base.getBaseHP());


    }

}
