/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 4:00 CH
 * Filename  : WithDrawThread
 */
public class WithDrawThread extends Thread {
    private String name;
    private Bank bank;

    public WithDrawThread(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            bank.withDraw(800, name);
        }
    }
}
