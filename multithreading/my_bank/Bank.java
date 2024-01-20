/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 3:56 CH
 * Filename  : Bank
 */
public class Bank {
    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public Bank() {

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void withDraw(int money, String threadName) {
        if (money <= this.money) {
            System.out.println("So tien rut: " + money + ". Thread name: " + threadName);
            this.money -= money;
        } else {
            System.out.println("So tien rut vuot qua so tien hien tai" + ". Thread name: " + threadName);
        }
        System.out.println("So tien hien tai: " + this.money);
    }
}
