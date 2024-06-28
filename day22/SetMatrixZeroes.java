import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int arr1[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int arr2[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        printResult(arr);
        System.out.println();
        setMatrixZeroes1(arr);
        System.out.println();
        setMatrixZeroes2(arr1);
        System.out.println();
        setMatrixZeroes3(arr2);
    }

    private static void setMatrixZeroes1(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] && col[j]) {
                    setZeros(matrix, i, j);
                }
            }
        }
        printResult(matrix);
    }

    private static void setZeros(int arr[][], int i, int j) {
        int row = 0;
        int col = 0;
        while (row < arr.length) {
            arr[row++][j] = 0;
        }
        while (col < arr[0].length) {
            arr[i][col++] = 0;
        }
    }

    private static void printResult(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrixZeroes2(int[][] matrix) {
        Set<Integer> rowSet = new HashSet();
        Set<Integer> colSet = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        printResult(matrix);
    }

    private static void setMatrixZeroes3(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        printResult(matrix);
    }


}
