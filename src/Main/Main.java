package Main;


public class Main {
    public static void main(String[] args) {
        Unit knight = new Knight("knight");
        Unit mage = new Mage("mage");

        knight.act();
        mage.act();
        mage.tp();
        knight.tp();

    }

}
