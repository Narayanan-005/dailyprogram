import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeyPair {
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, 8};
        System.out.println(keyPair1(arr.clone(), 16));
        System.out.println(keyPair2(arr.clone(), 16));
        System.out.println(keyPair3(arr.clone(), 16));
    }

    private static boolean keyPair1(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean keyPair2(int arr[], int x) {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) {
                return true;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    private static boolean keyPair3(int arr[], int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(x - arr[i])) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
