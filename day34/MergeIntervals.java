import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        printResult(mergeIntervals1(arr));
        printResult(mergeIntervals2(arr1));
    }

    private static void printResult(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (i != 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(ints[i]));
        }
        System.out.println();
    }

    private static int[][] mergeIntervals1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int l = intervals.length;
        int count = 0;
        for (int i = 0; i < l - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = (intervals[i + 1][1] > intervals[i][1] ? intervals[i + 1][1] : intervals[i][1]);
                intervals[i] = null;
                count++;
            }
        }
        int[][] res = new int[l - count][];
        for (int i = 0, j = 0; i < l; i++) {
            if (intervals[i] != null) {
                res[j++] = intervals[i];
            }
        }
        return res;
    }

    private static int[][] mergeIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int l = intervals.length;
        int count = 0;
        for (int i = 0; i < l - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                int j = i + 1;
                while (j < l && intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = (intervals[i][1] > intervals[j][1] ? intervals[i][1] : intervals[j][1]);
                    intervals[j] = null;
                    count++;
                    j++;
                }
                i = j - 1;
            }
        }
        int[][] res = new int[l - count][];
        for (int i = 0, j = 0; i < l; i++) {
            if (intervals[i] != null) {
                res[j++] = intervals[i];
            }
        }
        return res;
    }
}
