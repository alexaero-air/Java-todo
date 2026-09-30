package Main;

public class FileLoader extends Thread{
    private final String fileName;

    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Загрузка " + fileName + " началась...");
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (Exception _){}
        System.out.println(fileName + " успешно загружен!");
    }
}
