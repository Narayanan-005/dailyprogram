import java.util.*;

public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(sortArraybyIncreasingFrequency1(arr)));
        System.out.println(Arrays.toString(sortArraybyIncreasingFrequency2(arr)));
    }

    private static int[] sortArraybyIncreasingFrequency1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey() - a.getKey();
            } else {
                return a.getValue() - b.getValue();
            }
        });
        for (int i = 0, j = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            int key = entry.getKey();
            int val = entry.getValue();
            while (val-- > 0) {
                nums[j] = key;
                j++;
            }
        }
        return nums;
    }

    private static int[] sortArraybyIncreasingFrequency2(int[] nums) {
        int count[] = new int[201];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 100]++;
        }
        int index = 0, rep = 1;
        outer:
        while (true) {
            for (int i = count.length - 1; i >= 0; i--) {
                if (rep == 101 || index == nums.length) {
                    break outer;
                }
                if (count[i] == rep) {
                    while (count[i]-- > 0) {
                        nums[index++] = i - 100;
                    }
                }
            }
            rep++;
        }
        return nums;
    }
}
