import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoSum {

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(arr, 9)));
        System.out.println(Arrays.toString(twoSum2(arr, 9, 0, 1)));
        System.out.println(Arrays.toString(twoSum3(arr, 9)));
    }

    private static int[] twoSum1(int[] arr, int target) {
        int[] res = new int[2];
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break outer;
                }
            }
        }
        return res;
    }

    private static int[] twoSum2(int[] arr, int target, int i, int j) {
        if (i == arr.length) {
            return new int[2];
        } else if (j == arr.length) {
            i = i + 1;
            j = i + 1;
        }
        if (arr[i] + arr[j] == target) {
            return new int[]{i, j};
        }
        return twoSum2(arr, target, i, j + 1);
    }

    private static int[] twoSum3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i]) && map.get(target - arr[i]) != i) {
                return new int[]{i, map.get(target - arr[i])};
            }
            map.put(arr[i], i);
        }
        return new int[2];
    }
}
