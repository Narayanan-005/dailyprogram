import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {
    public static void main(String[] args) {
        System.out.println(maxNumberofKSumPairs1(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxNumberofKSumPairs2(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxNumberofKSumPairs3(new int[]{1, 2, 3, 4}, 5));
    }

    private static int maxNumberofKSumPairs1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == -1) {
                    continue;
                }
                if (nums[i] + nums[j] == k) {
                    count++;
                    nums[j] = -1;
                    break;
                }
            }
        }
        return count;
    }

    private static int maxNumberofKSumPairs2(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.containsKey(k - i)) {
                if (i == k - i) {
                    count += map.get(k - i) / 2;
                } else {
                    int min = Math.min(map.get(i), map.get(k - i));
                    count += min;
                    map.put(i, map.get(i) - min);
                    map.put(k - i, map.get(k - i) - min);
                }
            }
        }
        return count;
    }

    private static int maxNumberofKSumPairs3(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
