public class MaximumNumberofOperationsWiththeSameScoreI {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4, 5};
        System.out.println(maximumNumberofOperationsWiththeSameScoreI1(arr.clone()));
        System.out.println(maximumNumberofOperationsWiththeSameScoreI2(arr.clone()));
    }

    private static int maximumNumberofOperationsWiththeSameScoreI1(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i += 2) {
            nums[i] = nums[i] + nums[i + 1];
        }
        for (int i = 2; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i - 2]) {
                break;
            }
            count++;
        }
        return count;
    }

    private static int maximumNumberofOperationsWiththeSameScoreI2(int[] nums) {
        int pre = -1;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (pre == -1) {
                pre = nums[i] + nums[i + 1];
            } else if (pre != nums[i] + nums[i + 1]) {
                break;
            }
            count++;
        }
        return count;
    }
}
