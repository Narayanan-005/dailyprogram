public class MaximumProductSubarray {
    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        System.out.println(maximumProductSubarray1(arr));
        System.out.println(maximumProductSubarray2(arr));
    }

    private static int maximumProductSubarray1(int nums[]) {
        int max = nums[0];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < 0)
                    flag = flag ? false : true;
                product *= nums[j];
                if (!flag)
                    max = Math.max(max, product);
            }
            flag = false;
        }
        return max;
    }

    private static int maximumProductSubarray2(int nums[]) {
        int l = nums.length;
        long pre = 1;
        long post = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre *= nums[i];
            post *= nums[l - 1 - i];
            if (pre >= Integer.MIN_VALUE && pre <= Integer.MAX_VALUE) {
                max = Math.max(max, (int) pre);
            } else
                pre = 1;
            if (post >= Integer.MIN_VALUE && post <= Integer.MAX_VALUE)
                max = Math.max(max, (int) post);
            else
                post = 1;
            if (pre == 0) {
                pre = 1;
            }
            if (post == 0) {
                post = 1;
            }
        }
        return max;
    }
}
