package Main;

public class A extends Thread{
    @Override
    public void run() {
        for (int i=0; i<3; i++){
            System.out.println("A: " + i);
        }
    }
}
