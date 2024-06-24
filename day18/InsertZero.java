import java.util.ArrayList;
import java.util.List;

public class InsertZero {
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(insertZero1(arr, 2));
        System.out.println(insertZero2(arr, 2, new ArrayList<>(), 0, 0));
        System.out.println(insertZero3(arr, 2));
    }

    private static List<Integer> insertZero1(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                list.add(0);
                count = 0;
            }
        }
        return list;
    }

    private static List<Integer> insertZero2(int[] arr, int k, List<Integer> list, int count, int index) {
        if (index == arr.length) {
            return list;
        }
        list.add(arr[index]);
        if (arr[index] == 1) {
            count++;
        } else {
            count = 0;
        }
        if (count == k) {
            list.add(0);
            count = 0;
        }
        return insertZero2(arr, k, list, count, index + 1);
    }

    private static List<Integer> insertZero3(int[] arr, int k) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                builder.append(0);
                count = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < builder.length(); i++) {
            list.add(builder.charAt(i) - '0');
        }
        return list;
    }
}
