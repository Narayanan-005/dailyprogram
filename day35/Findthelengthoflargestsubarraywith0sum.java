import java.util.HashMap;
import java.util.Map;

public class Findthelengthoflargestsubarraywith0sum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(findthelengthoflargestsubarraywith0sum1(arr));
        System.out.println(findthelengthoflargestsubarraywith0sum2(arr));
        System.out.println(findthelengthoflargestsubarraywith0sum3(arr));
    }

    private static int findthelengthoflargestsubarraywith0sum1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    max = Math.max(max, (j - i + 1));
                }
            }
        }
        return max;
    }

    private static int findthelengthoflargestsubarraywith0sum2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                max = i + 1;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    private static int findthelengthoflargestsubarraywith0sum3(int[] nums) {
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = 0;
        for (int i = prefix.length - 1; i >= 0; i--) {
            int j = 0;
            while (j < i) {
                if (prefix[i] == prefix[j]) {
                    max = Math.max(max, (i - j));
                    break;
                }
                j++;
            }
        }
        return max;
    }
}
