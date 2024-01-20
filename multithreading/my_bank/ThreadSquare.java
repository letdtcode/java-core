import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 4:36 CH
 * Filename  : ThreadSquare
 */
public class ThreadSquare extends Thread {
    private SharedData sharedData;

    public ThreadSquare(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (sharedData) {
                try {
                    sharedData.notifyAll();
                    sharedData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadSquare.class.getName()).log(Level.SEVERE, null, e);
                }
                int rad = sharedData.getRandom();
                rad *= rad;
                System.out.println("PT " + rad);
            }
        }

        sharedData.notifyAll();
    }
}
