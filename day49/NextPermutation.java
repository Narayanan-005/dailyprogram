import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3};
        int arr2[] = {1, 2, 3};
        nextPermutation1(arr1);
        System.out.println(Arrays.toString(arr1));
        nextPermutation2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static void nextPermutation1(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[index] < nums[i]) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        index++;
        int right = nums.length - 1;
        while (index < right) {
            temp = nums[index];
            nums[index] = nums[right];
            nums[right] = temp;
            index++;
            right--;
        }
    }

    private static void nextPermutation2(int[] nums) {
        int l = nums.length;
        boolean swapped = false;
        int max = -1;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] < nums[j]) {
                    if (max == -1) {
                        max = j;
                    } else {
                        if (nums[max] > nums[j]) {
                            max = j;
                        }
                    }
                }
            }
            if (max != -1) {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
                Arrays.sort(nums, i + 1, l);
                swapped = true;
                break;
            }
            max = -1;
        }
        if (!swapped) {
            Arrays.sort(nums);
        }
    }
}
