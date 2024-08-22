import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays {
    public static void main(String[] args) {
        System.out.println(countNumberofNiceSubarrays1(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(countNumberofNiceSubarrays2(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(countNumberofNiceSubarrays3(new int[]{1, 1, 2, 1, 1}, 3));
    }

    private static int countNumberofNiceSubarrays1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    count++;
                }
                if (count == k) {
                    res++;
                }
                if (count > k) {
                    break;
                }
            }
        }
        return res;
    }

    private static int countNumberofNiceSubarrays2(int[] nums, int k) {
        int list[] = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list[size++] = i;
            }
        }
        int res = 0;
        for (int i = 0; i < size - k + 1; i++) {
            int pre = (i == 0 ? list[i] + 1 : list[i] - list[i - 1]);
            int post = (i + k == size ? nums.length - list[i + k - 1] : list[i + k] - list[i + k - 1]);
            res += pre * post;
        }
        return res;
    }

    private static int countNumberofNiceSubarrays3(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int prefSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefSum += (nums[i] % 2 == 1) ? 1 : 0;
            ans += freq.getOrDefault(prefSum - k, 0);
            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        }
        return ans;
    }
}
