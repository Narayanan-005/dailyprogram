public class SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        System.out.println(searchInsertPosition1(nums, 2));
        System.out.println(searchInsertPosition2(nums, 2));
    }

    private static int searchInsertPosition1(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    private static int searchInsertPosition2(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
