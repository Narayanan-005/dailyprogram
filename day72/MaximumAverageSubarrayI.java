public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(maximumAverageSubarrayI1(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(maximumAverageSubarrayI2(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(maximumAverageSubarrayI3(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    private static double maximumAverageSubarrayI1(int[] nums, int k) {
        double average = -1001;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            average = Math.max(average, (double) sum / k);
        }
        return average;
    }

    private static double maximumAverageSubarrayI2(int[] nums, int k) {
        double[] preSum = new double[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            if (i >= k) {
                preSum[i] -= nums[i - k];
            }
        }
        double max = -1001;
        for (int i = k - 1; i < nums.length; i++) {
            max = Math.max(max, preSum[i] / k);
        }
        return max;
    }

    private static double maximumAverageSubarrayI3(int[] nums, int k) {
        int sum = 0;
        double avg = -1001;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (i < k - 1) {
                sum += nums[i];
            } else {
                sum += nums[i];
                avg = Math.max(avg, (double) sum / k);
                sum -= nums[i - k + 1];
            }
        }
        return avg;
    }
}
