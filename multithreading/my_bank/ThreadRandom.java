import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 4:33 CH
 * Filename  : ThreadRandom
 */
public class ThreadRandom extends Thread {
    private SharedData sharedData;

    public ThreadRandom(SharedData data) {
        this.sharedData = data;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            synchronized (sharedData) {
                int rad = random.nextInt(100) + 1;
                sharedData.setRandom(rad);
                System.out.println("Rad: " + rad);
//            Trien khai them
//            wait => T2 chay
                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadRandom.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        sharedData.notifyAll();
    }
}
