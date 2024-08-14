import java.util.HashMap;
import java.util.Map;

public class FindtheNumberofGoodPairsII {
    public static void main(String[] args) {
        System.out.println(findtheNumberofGoodPairsII1(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(findtheNumberofGoodPairsII2(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(findtheNumberofGoodPairsII3(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
    }

    private static long findtheNumberofGoodPairsII1(int[] nums1, int[] nums2, int k) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static long findtheNumberofGoodPairsII2(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            int prod = nums2[i] * k;
            map2.put(prod, map2.getOrDefault(prod, 0) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        long count = 0;
        for (Integer i : map1.keySet()) {
            for (Integer j : map2.keySet()) {
                if (i % j == 0) {
                    count += (long) map1.get(i) * map2.get(j);
                }
            }
        }
        return count;
    }

    private static long findtheNumberofGoodPairsII3(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num * k, map.getOrDefault(num * k, 0) + 1);
        }
        long res = 0;
        for (int num : nums1) {
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    int div = num / i;

                    res += map.getOrDefault(i, 0);
                    if (div != i) {
                        res += map.getOrDefault(div, 0);
                    }
                }
            }
        }
        return res;
    }
}
