import java.util.Arrays;

public class NumberofGoodPairs {
    public static void main(String[] args) {
        System.out.println(numberofGoodPairs1(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numberofGoodPairs2(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numberofGoodPairs3(new int[]{1, 2, 3, 1, 1, 3}));
    }

    private static int numberofGoodPairs1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int numberofGoodPairs2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                res += (count-- * count) / 2;
                count = 1;
            }
        }
        res += (count-- * count) / 2;
        return res;
    }

    private static int numberofGoodPairs3(int[] nums) {
        int[] map = new int[101];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        int count = 0;
        for (int i = 1; i < 101; i++) {
            if (map[i] > 1)
                count += (map[i]-- * map[i]) / 2;
        }
        return count;
    }
}
