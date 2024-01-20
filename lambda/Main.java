/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 16/12/2023
 * Time      : 6:22 CH
 * Filename  : Main
 */
public class Main {
    public static void main(String[] args) {
        Animal meo2 = (firstName, lastName) -> {
            System.out.println("Day la con meo 2");
            return firstName + lastName;
        };
        System.out.println(meo2.speak("tom", "jerry"));
    }
}
