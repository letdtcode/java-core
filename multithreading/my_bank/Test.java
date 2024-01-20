import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 4:03 CH
 * Filename  : Test
 */
public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);

//        bank.withDraw(800,"T0");
//        bank.withDraw(800,"T1");
//        bank.withDraw(800,"T2");

        List<WithDrawThread> multipleThread = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            multipleThread.add(new WithDrawThread("T" + i, bank));
        }

        for (WithDrawThread withDrawThread : multipleThread) {
            withDrawThread.start();
        }
    }
}
