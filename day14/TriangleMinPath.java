import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinPath {
    public static void main(String[] args) {
        List<List<Integer>> input = input();
        System.out.println(triangleMinPath1(input));
        System.out.println(triangleMinPath2(input));
    }

    private static List<List<Integer>> input() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> li1 = new ArrayList<>();
        li1.add(2);
        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(4);
        List<Integer> li3 = new ArrayList<>();
        li3.add(6);
        li3.add(5);
        li3.add(7);
        List<Integer> li4 = new ArrayList<>();
        li4.add(4);
        li4.add(1);
        li4.add(8);
        li4.add(3);
        list.add(li1);
        list.add(li2);
        list.add(li3);
        list.add(li4);
        return list;
    }

    private static int triangleMinPath1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int last[] = new int[n];
        for (int j = 0; j < n; j++) {
            last[j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            int cur[] = new int[n];
            for (int j = i; j >= 0; j--) {

                int down = triangle.get(i).get(j) + last[j];
                int diagonal = triangle.get(i).get(j) + last[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            last = cur;
        }
        return last[0];
    }

    private static int triangleMinPath2(List<List<Integer>> triangle) {
        int[][] val = new int[triangle.size()][triangle.size()];
        for (int[] arr : val)
            Arrays.fill(arr, -10001);
        return minPath(triangle, 0, 0, val);
    }

    private static int minPath(List<List<Integer>> triangle, int i, int j, int[][] val) {
        if (i == triangle.size())
            return 0;

        if (val[i][j] != -10001)
            return val[i][j];

        int a = triangle.get(i).get(j) + minPath(triangle, i + 1, j, val);
        int b = triangle.get(i).get(j) + minPath(triangle, i + 1, j + 1, val);
        return val[i][j] = Math.min(a, b);

    }
}
