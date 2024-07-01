import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subarraySumEqualsK1(nums, 3));
        System.out.println(subarraySumEqualsK2(nums, 3));
        System.out.println(subarraySumEqualsK3(nums, 3));
    }

    private static int subarraySumEqualsK1(int[] nums, int k) {
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    private static int subarraySumEqualsK2(int[] nums, int k) {
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int subarraySumEqualsK3(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
