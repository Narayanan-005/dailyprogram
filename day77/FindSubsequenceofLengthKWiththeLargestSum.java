import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSubsequenceofLengthKWiththeLargestSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSubsequenceofLengthKWiththeLargestSum1(new int[]{2, 1, 3, 3}, 2)));
        System.out.println(Arrays.toString(findSubsequenceofLengthKWiththeLargestSum2(new int[]{2, 1, 3, 3}, 2)));
    }

    private static int[] findSubsequenceofLengthKWiththeLargestSum1(int[] nums, int k) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> nums[b] - nums[a]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < k; i++) {
            res[i] = nums[res[i]];
        }
        return res;
    }

    private static int[] findSubsequenceofLengthKWiththeLargestSum2(int[] nums, int k) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> nums[b] - nums[a]);
        Set<Integer> set = new HashSet();
        for (int i = 0; i < k; i++) {
            set.add(arr[i]);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

}
