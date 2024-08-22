import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SortthePeople {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortthePeople1(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(sortthePeople2(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }

    private static String[] sortthePeople1(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int i = names.length - 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            names[i--] = entry.getValue();
        }
        return names;
    }

    private static String[] sortthePeople2(String[] names, int[] heights) {
        int l = heights.length;
        int arr[][] = new int[l][2];
        for (int i = 0; i < l; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        String[] res = new String[l];
        for (int i = 0; i < l; i++) {
            res[i] = names[arr[l - 1 - i][1]];
        }
        return res;
    }
}
