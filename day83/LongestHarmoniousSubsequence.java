import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(longestHarmoniousSubsequence1(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(longestHarmoniousSubsequence2(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    private static int longestHarmoniousSubsequence1(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

    private static int longestHarmoniousSubsequence2(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        int n1 = 0, n2 = 0;
        int ele1 = 1000000001, ele2 = nums[0];
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                n2++;
            } else {
                if (n1 != 0 && n2 != 0 && ele1 + 1 == ele2) {
                    max = Math.max(max, n1 + n2);
                }
                ele1 = ele2;
                n1 = n2;
                n2 = 1;
                pre = nums[i];
                ele2 = pre;
            }
        }
        if (n1 != 0 && ele1 + 1 == ele2)
            max = Math.max(max, n1 + n2);
        return max;
    }
}
