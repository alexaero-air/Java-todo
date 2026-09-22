package Main;

public class Unit {
    String name;

    public Unit(String name) {
        this.name = name;
    }

    public void act(){
        System.out.println(this.name + " Waiting");
    }
    public void tp(){
        System.out.println(this.name + " is Unable to do that");
    }
}
