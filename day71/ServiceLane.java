import java.util.ArrayList;
import java.util.List;

public class ServiceLane {
    public static void main(String[] args) {
        List<List<Integer>> cases = new ArrayList<>();
        cases.add(List.of(1, 2));
        cases.add(List.of(2, 4));
        List<Integer> width = List.of(2, 3, 2, 1);
        System.out.println(serviceLane1(4, cases, width));
        System.out.println(serviceLane2(4, cases, width));
    }

    private static List<Integer> serviceLane1(int n, List<List<Integer>> cases, List<Integer> width) {
        List<Integer> list = new ArrayList();
        for (List<Integer> li : cases) {
            int start = li.get(0);
            int end = li.get(1);
            if (end >= n) {
                end = n - 1;
            }
            int min = 4;
            for (; start <= end; start++) {
                min = Math.min(min, width.get(start));
            }
            list.add(min);
        }
        return list;
    }

    private static List<Integer> serviceLane2(int n, List<List<Integer>> cases, List<Integer> width) {
        int[][] preSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            preSum[i][i] = width.get(i);
            for (int j = i + 1; j < n; j++) {
                preSum[i][j] = Math.min(width.get(j), preSum[i][j - 1]);
            }
        }
        List<Integer> list = new ArrayList();
        for (List<Integer> li : cases) {
            int start = li.get(0);
            int end = li.get(1);
            if (end >= n) {
                end = n - 1;
            }
            list.add(preSum[start][end]);
        }
        return list;
    }
}
