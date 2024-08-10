import java.util.ArrayList;
import java.util.List;

public class FindthePeaks {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 8, 5};
        System.out.println(findthePeaks1(arr));
        System.out.println(findthePeaks2(arr));
    }

    private static List<Integer> findthePeaks1(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                list.add(i);
            }
        }
        return list;
    }

    private static List<Integer> findthePeaks2(int[] mountain) {
        List<Integer> list = new ArrayList();
        recPeak(mountain, 1, list);
        return list;
    }

    private static void recPeak(int arr[], int index, List<Integer> list) {
        if (index == arr.length - 1) {
            return;
        }
        if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
            list.add(index);
        }
        recPeak(arr, index + 1, list);
    }
}
