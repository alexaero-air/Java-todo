package Main;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Unit knight = new Knight("knight");
//        Unit mage = new Mage("mage");

//        knight.act();
//        mage.act();
//        mage.tp();
//        knight.tp();

        ArrayList<Unit> squad = new ArrayList<>();
        squad.add(new Unit("Just"));
        squad.add(new Mage("mage"));
        squad.add(new Knight("knight"));

        for (Unit unit : squad){
            unit.act();
        }
    }
}
