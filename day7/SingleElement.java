import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 2, 3, 4, 5, 9, 8, 9, 8, 5};
        System.out.println(singleElement1(arr));
        System.out.println(singleElement2(arr.clone()));
        System.out.println(singleElement3(arr));
    }

    private static int singleElement1(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int singleElement2(int arr[]) {
        Arrays.sort(arr);
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                return arr[i - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private static int singleElement3(int arr[]) {
        int oddManOut = 0;
        for (int i = 0; i < arr.length; i++) {
            oddManOut ^= arr[i];
        }
        return oddManOut;
    }
}
