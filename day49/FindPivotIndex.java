public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(findPivotIndex1(arr));
        System.out.println(findPivotIndex2(arr));
        System.out.println(findPivotIndex3(arr));
    }

    private static int findPivotIndex1(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int j = 0;
            int k = i + 1;
            int left = 0, right = 0;
            while (j < i) {
                left += nums[j++];
            }
            while (k < l) {
                right += nums[k++];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    private static int findPivotIndex2(int[] nums) {
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            r -= nums[i];
            if (l == r) {
                return i;
            }
            l += nums[i];
        }
        return -1;
    }

    private static int findPivotIndex3(int[] nums) {
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        for (int i = 1; i < l; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = l - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < l; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}
