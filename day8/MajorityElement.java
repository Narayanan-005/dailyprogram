import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement1(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr, 0, 0, 0));
    }

    private static int majorityElement1(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    private static int majorityElement2(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > arr.length / 2) {
                return i;
            }
        }
        return 0;
    }

    private static int majorityElement3(int arr[], int element, int count, int index) {
        if (index == arr.length) {
            return element;
        }
        if (count == 0) {
            element = arr[index];
        }
        if (element == arr[index]) {
            count++;
        } else {
            count--;
        }
        return majorityElement3(arr, element, count, index + 1);
    }
}
