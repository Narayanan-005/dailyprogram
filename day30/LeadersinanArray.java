import java.util.ArrayList;
import java.util.List;

public class LeadersinanArray {
    public static void main(String[] args) {
        int arr[] = {2, 34, 5, 34, 22, 3, 5, 2};
        System.out.println(leadersinanArray1(arr));
        System.out.println(leadersinanArray2(arr));
    }

    private static List<Integer> leadersinanArray1(int arr[]) {
        List<Integer> list = new ArrayList<>();
        outer:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    continue outer;
                }
            }
            list.add(arr[i]);
        }
        return list;
    }

    private static List<Integer> leadersinanArray2(int arr[]) {
        List<Integer> list = new ArrayList<>();
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(0, arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
}
