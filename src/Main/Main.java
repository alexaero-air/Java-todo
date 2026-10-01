package Main;

public class Main {
    public static void main(String[] args) {
        new FileLoader("wrs.txt").start();
        new FileLoader("video.mp4").start();
        new FileLoader("audio.mp3").start();
    }
}
