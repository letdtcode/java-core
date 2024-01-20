import java.util.HashSet;
import java.util.Set;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 16/12/2023
 * Time      : 5:40 CH
 * Filename  : Main
 */
//class Hinh {
//    public void ve() {
//        System.out.println("Đang vẽ hình...");
//    }
//}
//
//class HinhVuong extends Hinh {
////    @Override
////    public void ve() {
////        System.out.println("Đang vẽ hình vuông");
////    }
//}


public class Main {
    private Set<String> s = new HashSet<>();

    {
        s.add("hehe");
    }


    public static void main(String[] args) {
        System.out.println(new Main().s);
    }
}
