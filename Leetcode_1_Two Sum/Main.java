import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 30/12/2023
 * Time      : 4:10 CH
 * Filename  : Main
 */
public class Main {
    List<Song> list = new ArrayList();

    {
        list.add("hehe");
        list.add(2);

    }
//    ArrayList list2 = new ArrayList();


//
//    public int[] twoSum(int[] nums, int target) {
//        int[] ans = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int numA = nums[i];
//                int numB = nums[j];
//                int result = numA + numB;
//                if (result == target) {
//                    ans[0] = i;
//                    ans[1] = j;
//                    return ans;
//                }
//            }
//        }
//        return null;
//    }

    public void go() {
//        List<Song> songList = MockSong.getSongsV2();
//        System.out.print(songList);
//        Collections.sort(songList);
//        System.out.println(songList);
    }

    public static void main(String[] args) {
//        Song song = new Song("haha", "hehe", 12);
        Main main = new Main();
        System.out.print(main.list);
    }
}
