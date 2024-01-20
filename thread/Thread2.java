/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 27/12/2023
 * Time      : 6:12 CH
 * Filename  : Thread2
 */
public class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B" + i);
        }
    }
}
