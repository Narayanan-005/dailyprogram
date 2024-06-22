import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 6, 1, 6, 2};
        findOccurrence1(arr.clone());
        System.out.println();
        findOccurrence2(arr.clone());
        System.out.println();
        findOccurrence3(arr.clone());
    }

    private static void findOccurrence1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (arr[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = -1;
                }
            }
            System.out.println(arr[i] + "-" + count);
        }
    }

    private static void findOccurrence2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    private static void findOccurrence3(int[] arr) {
        Arrays.sort(arr);
        int i = 1, j = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                System.out.println(arr[i - 1] + "-" + (i - j));
                j = i;
            }
        }
        System.out.println(arr[i - 1] + "-" + (i - j));
    }
}
