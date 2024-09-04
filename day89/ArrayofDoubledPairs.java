import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ArrayofDoubledPairs {
    public static void main(String[] args) {
        System.out.println(arrayofDoubledPairs1(new int[]{3, 1, 3, 6}));
        System.out.println(arrayofDoubledPairs2(new int[]{3, 1, 3, 6}));
    }

    private static boolean arrayofDoubledPairs1(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (map.get(0) > 1) {
                    count++;
                    map.put(0, map.get(0) - 2);
                }
                continue;
            }
            if (map.containsKey(arr[i] * 2) && map.get(arr[i]) > 0) {
                Integer val = map.get(arr[i] * 2);
                if (val != 0) {
                    count++;
                    map.put(arr[i] * 2, val - 1);
                    map.put(arr[i], map.get(arr[i]) - 1);
                    if (count == arr.length / 2) {
                        return true;
                    }
                }
            }
        }
        return count == arr.length / 2;
    }

    private static boolean arrayofDoubledPairs2(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int x : map.keySet()) {
            if (map.get(x) == 0)
                continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || map.get(x) > map.getOrDefault(want, 0))
                return false;
            map.put(want, map.get(want) - map.get(x));
        }
        return true;
    }
}
