import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(permutations1(arr));
        System.out.println(permutations2(arr));
    }

    private static List<List<Integer>> permutations1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute1(list, new ArrayList<>(), nums);
        return list;
    }

    private static void permute1(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permute1(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static List<List<Integer>> permutations2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute2(nums, 0, res);
        return res;
    }

    public static void permute2(int[] arr, int n, List<List<Integer>> res) {
        if (n == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int j : arr) {
                list.add(j);
            }
            res.add(list);
        }
        for (int i = n; i < arr.length; i++) {
            swap(arr, i, n);
            permute2(arr, n + 1, res);
            swap(arr, i, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
