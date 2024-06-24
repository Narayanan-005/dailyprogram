import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecondHighOccurrence {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3, 1, 2, 4};
        System.out.println(secondHighOccurrence1(arr));
        System.out.println(secondHighOccurrence2(arr));
        System.out.println(secondHighOccurrence3(arr));
    }

    private static int secondHighOccurrence1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int first = 0, firstEle = -1, second = 0, secondEle = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > first) {
                second = first;
                secondEle = firstEle;
                first = val;
                firstEle = key;
            } else if (val > second) {
                second = val;
                secondEle = key;
            }
        }
        return secondEle;
    }

    private static int secondHighOccurrence2(int[] arr) {
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                l = arr[i];
            }
        }
        int occurrence[] = new int[l + 1];
        for (int i = 0; i < arr.length; i++) {
            occurrence[arr[i]]++;
        }
        int first = 0;
        int second = 0;
        if (occurrence[0] > occurrence[l]) {
            first = 0;
            second = l;
        } else {
            first = l;
            second = 0;
        }
        for (int i = 1; i < l; i++) {
            if (occurrence[i] > occurrence[first]) {
                second = first;
                first = i;
            } else if (occurrence[i] > occurrence[second]) {
                second = i;
            }
        }
        return second;
    }

    private static int secondHighOccurrence3(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int first = 0, firstEle = -1, second = 0, secondEle = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
            if (arr[i] != arr[i - 1] || i == arr.length - 1) {
                if (count > first) {
                    second = first;
                    secondEle = firstEle;
                    first = count;
                    firstEle = arr[i - 1];
                } else if (count > second) {
                    second = count;
                    secondEle = arr[i - 1];
                }
                count = 0;
            }
        }
        return secondEle;
    }
}
