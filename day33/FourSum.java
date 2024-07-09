import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum1(arr, 0));
        System.out.println(fourSum2(arr, 0));
    }

    private static List<List<Integer>> fourSum1(int[] nums, int target) {
        int l = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    for (int m = k + 1; m < l; m++) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        for (List<Integer> list1 : set) {
            list.add(list1);
        }
        return list;
    }

    private static List<List<Integer>> fourSum2(int[] nums, int target) {
        int l = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < l; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = l - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return list;
    }
}
