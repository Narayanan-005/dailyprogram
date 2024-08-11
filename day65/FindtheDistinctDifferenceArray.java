import java.util.*;

public class FindtheDistinctDifferenceArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findtheDistinctDifferenceArray1(arr)));
        System.out.println(Arrays.toString(findtheDistinctDifferenceArray2(arr)));
        System.out.println(Arrays.toString(findtheDistinctDifferenceArray3(arr)));
    }

    private static int[] findtheDistinctDifferenceArray1(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = getDistinct(nums, i);
        }
        return res;
    }

    private static int getDistinct(int arr[], int mid) {
        Set<Integer> setL = new HashSet();
        Set<Integer> setR = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (i <= mid) {
                setL.add(arr[i]);
            } else {
                setR.add(arr[i]);
            }
        }
        return setL.size() - setR.size();
    }

    private static int[] findtheDistinctDifferenceArray2(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res[] = new int[nums.length];
        Set<Integer> set = new HashSet();
        int right = map.size();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) <= 0) {
                right--;
            }
            set.add(nums[i]);
            res[i] = set.size() - right;
        }
        return res;
    }

    private static int[] findtheDistinctDifferenceArray3(int[] nums) {
        int[] mapR = new int[51];
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mapR[nums[i]]++ == 0) {
                right++;
            }
        }
        int[] mapL = new int[51];
        int[] res = new int[nums.length];
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mapL[nums[i]]++ == 0) {
                left++;
            }
            if (--mapR[nums[i]] == 0) {
                right--;
            }
            res[i] = left - right;
        }
        return res;
    }
}
