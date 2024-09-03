public class ShortestSubarrayWithORatLeastKI {
    public static void main(String[] args) {
        System.out.println(shortestSubarrayWithORatLeastKI1(new int[]{1, 2, 3}, 2));
    }

    private static int shortestSubarrayWithORatLeastKI1(int[] nums, int k) {
        int min = nums.length + 1;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                xor |= nums[j];
                if (xor >= k) {
                    min = Math.min(min, (j - i + 1));
                    break;
                }
            }
            xor = 0;
        }
        return (min == nums.length + 1 ? -1 : min);
    }
}
