package Main;

public class Knight extends Unit{
    public Knight(String name) {
        super(name);
    }

    @Override
    public void act() {
        System.out.println(this.name + " Shield's up");;
    }
}
