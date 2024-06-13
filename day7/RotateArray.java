import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int arr1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        printResult(rotateArray1(arr));
        System.out.println();
        printResult(rotateArray2(arr1));
        System.out.println();
        printResult(rotateArray3(arr));
    }

    private static void printResult(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static int[][] rotateArray1(int[][] arr) {
        int res[][] = new int[arr.length][arr[0].length];
        int col = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int row = 0; row < arr.length; row++) {
                res[row][col] = arr[i][row];
            }
            col--;
        }
        return res;
    }

    private static int[][] rotateArray2(int[][] arr) {
        int res[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = arr[i].length - 1;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }
        return arr;
    }

    private static int[][] rotateArray3(int arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - 1 + i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - j - 1][i];
                arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
                arr[j][n - i - 1] = temp;
            }
        }
        return arr;
    }
}
