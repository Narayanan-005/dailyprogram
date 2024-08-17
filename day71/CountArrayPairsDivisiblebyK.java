import java.util.HashMap;
import java.util.Map;

public class CountArrayPairsDivisiblebyK {
    public static void main(String[] args) {
        System.out.println(countArrayPairsDivisiblebyK1(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(countArrayPairsDivisiblebyK2(new int[]{1, 2, 3, 4, 5}, 2));
    }

    private static long countArrayPairsDivisiblebyK1(int[] nums, int k) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long l = (long) nums[i] * nums[j];
                if ((l % k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long countArrayPairsDivisiblebyK2(int[] nums, int k) {
        long result = 0;
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcd = findGcd(nums[i], k);
            for (int num : gcdMap.keySet()) {
                if ((long) gcd * num % k == 0) {
                    result += gcdMap.get(num);
                }
            }
            gcdMap.put(gcd, gcdMap.getOrDefault(gcd, 0) + 1);
        }
        return result;
    }

    private static int findGcd(int x, int y) {
        if (x < y) {
            return findGcd(y, x);
        }
        return y == 0 ? x : findGcd(y, x % y);
    }
}
