import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 08/12/2023
 * Time      : 8:03 CH
 * Filename  : Main
 */
public class Main {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k)
                    ans++;
            }
        }
        return ans;
    }
    Map map = new HashMap();

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 2, 2, 1};
        int result = main.countKDifference(nums, 1);
        System.out.print(result);
    }
}
