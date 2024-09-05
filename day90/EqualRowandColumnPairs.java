import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs {
    public static void main(String[] args) {
        System.out.println(equalRowandColumnPairs1(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(equalRowandColumnPairs2(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
    }

    private static int equalRowandColumnPairs1(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (isSame(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSame(int[][] arr, int r, int c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[r][i] != arr[i][c]) {
                return false;
            }
        }
        return true;
    }

    private static int equalRowandColumnPairs2(int[][] grid) {
        Map<Integer, int[]> cols = new HashMap();
        int l = grid.length;
        for (int i = 0; i < l; i++) {
            int arr[] = new int[l];
            for (int j = 0; j < l; j++) {
                arr[j] = grid[j][i];
            }
            cols.put(i, arr);
        }
        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (Arrays.equals(grid[i], (cols.get(j)))) {
                    count++;
                }
            }
        }
        return count;
    }
}
