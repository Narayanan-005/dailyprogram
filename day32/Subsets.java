import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(subsets1(arr));
        System.out.println(subsets2(arr, 0, new ArrayList<>()));
        System.out.println(subsets3(arr));
    }

    private static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> li = new ArrayList();
            for (int j = nums.length - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    li.add(nums[nums.length - 1 - j]);
                }
            }
            list.add(li);
        }
        return list;
    }

    private static List<List<Integer>> subsets2(int[] nums, int index, List<Integer> res) {
        if (index == nums.length) {
            List<List<Integer>> list = new ArrayList();
            list.add(res);
            return list;
        }
        List<Integer> li = new ArrayList(res);
        li.add(nums[index]);
        List<List<Integer>> left = subsets2(nums, index + 1, res);
        List<List<Integer>> right = subsets2(nums, index + 1, li);
        right.addAll(left);
        return right;
    }

    private static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i : nums) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(i);
                res.add(list);
            }
        }
        return res;
    }
}
