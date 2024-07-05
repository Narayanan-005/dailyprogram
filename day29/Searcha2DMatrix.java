public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searcha2DMatrix1(mat, 3));
        System.out.println(searcha2DMatrix2(mat, 3));
        System.out.println(searcha2DMatrix3(mat, 3));
    }

    private static boolean searcha2DMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searcha2DMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && (i + 1 == matrix.length || matrix[i + 1][0] > target)) {
                return search(matrix[i], target);
            }
        }
        return false;
    }

    private static boolean search(int arr[], int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

    private static boolean searcha2DMatrix3(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[mid][0] <= target && (mid + 1 == matrix.length || matrix[mid + 1][0] > target)) {
                return search(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
