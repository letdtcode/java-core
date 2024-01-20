/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 27/12/2023
 * Time      : 6:11 CH
 * Filename  : Main
 */
public class Main {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread t = new Thread(thread1);

        Thread2 thread2 = new Thread2();

        t.start();
        thread2.start();
    }
}
