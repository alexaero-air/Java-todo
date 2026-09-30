package Main;

public class B extends Thread{
    @Override
    public void run() {
        for (int i=0; i<3; i++){
            System.out.println("B: " + i);
        }
    }
}
