import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(majorityElementII1(arr));
        System.out.println(majorityElementII2(arr));
        System.out.println(majorityElementII3(arr));
    }

    private static List<Integer> majorityElementII1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int l = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > l) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private static List<Integer> majorityElementII2(int[] nums) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        int l = nums.length / 3;
        for (int i = 0; i < nums.length - l; i++) {
            if (nums[i] == nums[i + l] && !list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    private static List<Integer> majorityElementII3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        int inc = -min;
        int[] map = new int[max + inc + 1];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + inc]++;
        }
        List<Integer> list = new ArrayList();
        int l = nums.length / 3;
        for (int i = 0; i < max + inc + 1; i++) {
            if (map[i] > l) {
                list.add(i - inc);
            }
        }
        return list;
    }
}
