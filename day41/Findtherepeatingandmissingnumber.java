import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Findtherepeatingandmissingnumber {
    public static void main(String[] args) {
        int arr[] = {1, 3, 3};
        System.out.println(Arrays.toString(findtherepeatingandmissingnumber1(arr)));
        System.out.println(Arrays.toString(findtherepeatingandmissingnumber2(arr)));
        System.out.println(Arrays.toString(findtherepeatingandmissingnumber3(arr)));
    }

    private static int[] findtherepeatingandmissingnumber1(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[] res = new int[2];
        for (int i = 1; i <= arr.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    res[0] = i;
                }
            } else {
                res[1] = i;
            }
        }
        return res;
    }

    private static int[] findtherepeatingandmissingnumber2(int arr[]) {
        Map<Integer, Integer> map = new HashMap();
        int l = arr.length;
        long sum = 0;
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                res[0] = arr[i];
            }
            map.put(arr[i], 1);
            sum += arr[i];
        }
        res[1] = (int) ((((long) l * (((long) l) + 1)) / 2) - (sum - res[0]));
        return res;
    }

    private static int[] findtherepeatingandmissingnumber3(int arr[]) {
        int[] res = new int[2];
        Arrays.sort(arr);
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pre == arr[i]) {
                res[0] = arr[i];
            } else if (arr[i] - pre == 2) {
                res[1] = pre + 1;
            }
            pre = arr[i];
        }
        if (res[1] == 0) {
            res[1] = arr.length;
        }
        return res;
    }
}
