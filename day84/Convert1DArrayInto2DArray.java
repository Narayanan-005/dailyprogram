import java.util.Arrays;

public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        printResult(convert1DArrayInto2DArray1(new int[]{1, 2, 3, 4}, 2, 2));
        System.out.println("====================================================");
        printResult(convert1DArrayInto2DArray2(new int[]{1, 2, 3, 4}, 2, 2));
        System.out.println("====================================================");
        printResult(convert1DArrayInto2DArray3(new int[]{1, 2, 3, 4}, 2, 2));
    }

    private static void printResult(int[][] ints) {
        for (int i = 0; i < ints.length; i++){
            for (int j = 0; j < ints[i].length; j++){
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] convert1DArrayInto2DArray1(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int arr[][] = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[k++];
            }
        }
        return arr;
    }

    private static int[][] convert1DArrayInto2DArray2(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] res = new int[m][];
        for (int i = 0; i < m; i++) {
            res[i] = Arrays.copyOfRange(original, i * n, (i + 1) * n);
        }
        return res;
    }

    private static int[][] convert1DArrayInto2DArray3(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int arr[][] = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            arr[i / n][i % n] = original[i];
        }
        return arr;
    }
}
