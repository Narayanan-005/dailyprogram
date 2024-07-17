import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int nums2[] = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElementI1(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementI2(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementI3(nums1, nums2)));
    }

    private static int[] nextGreaterElementI1(int nums1[], int nums2[]) {
        boolean found = false;
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
                if (found && nums1[i] < nums2[j]) {
                    num = nums2[j];
                    break;
                }
            }
            res[i] = num;
            found = false;
        }
        return res;
    }

    private static int[] nextGreaterElementI2(int nums1[], int nums2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        int res[] = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    private static int[] nextGreaterElementI3(int nums1[], int nums2[]) {
        int[] index = new int[10001];
        for (int i = 0; i < nums2.length; i++) {
            index[nums2[i]] = i;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = greatest(index[nums1[i]], nums2);
        }
        return nums1;
    }

    private static int greatest(int i, int nums[]) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                return nums[j];
            }
        }
        return -1;
    }
}
