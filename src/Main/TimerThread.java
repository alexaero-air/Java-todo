package Main;

public class TimerThread extends Thread{
    private final String name;

    TimerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try{
            for (int i=1; i<=5; i++){
                System.out.println(name + ": " + i + " сек");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
