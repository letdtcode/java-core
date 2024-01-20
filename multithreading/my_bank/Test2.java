/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 29/12/2023
 * Time      : 4:41 CH
 * Filename  : Test2
 */
public class Test2 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        ThreadRandom threadRandom = new ThreadRandom(sharedData);
        ThreadSquare threadSquare = new ThreadSquare(sharedData);

        threadRandom.start();
        threadSquare.start();
    }
}
