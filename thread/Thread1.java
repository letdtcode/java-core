/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 27/12/2023
 * Time      : 6:12 CH
 * Filename  : Thread1
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A" + i);
        }
    }
}
