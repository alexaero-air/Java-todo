package Main;

public class Mage extends Unit {
    public Mage(String name) {
        super(name);
    }

    @Override
    public void act() {
        System.out.println(this.name + " casting Fireball");;
    }
    @Override
    public void tp(){
        System.out.println(this.name + " Has teleported");
    }
}
