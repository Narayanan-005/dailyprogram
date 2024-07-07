import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralMatrix1(arr));
        System.out.println(spiralMatrix2(arr));
        System.out.println(spiralMatrix3(arr));
    }

    private static List<Integer> spiralMatrix1(int matrix[][]) {
        List<Integer> list = new ArrayList<>();
        int limit = matrix.length * matrix[0].length;
        for (int i = 0, j = 0, k = 0, c = 0; c < limit; k++, j++) {
            while (c < limit && j < matrix[0].length - k) {
                list.add(matrix[i][j++]);
                c++;
            }
            j--;
            while (c < limit && ++i < matrix.length - k) {
                list.add(matrix[i][j]);
                c++;
            }
            i--;
            while (c < limit && --j >= 0 + k) {
                list.add(matrix[i][j]);
                c++;
            }
            j++;
            while (c < limit && --i > 0 + k) {
                list.add(matrix[i][j]);
                c++;
            }
            i++;
        }
        return list;
    }

    private static List<Integer> spiralMatrix2(int matrix[][]) {
        List<Integer> list = new ArrayList();
        int limit = matrix.length * matrix[0].length;
        int flag = 1;
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int i = 0, j = 0;
        for (int k = 0; k < limit; k++) {
            if (flag == 1) {
                if (j == right) {
                    list.add(matrix[i++][j]);
                    top++;
                    flag = 2;
                } else {
                    list.add(matrix[i][j++]);
                }
            } else if (flag == 2) {
                if (i == bottom) {
                    list.add(matrix[i][j--]);
                    right--;
                    flag = 3;
                } else {
                    list.add(matrix[i++][j]);
                }
            } else if (flag == 3) {
                if (j == left) {
                    list.add(matrix[i--][j]);
                    bottom--;
                    flag = 4;
                } else {
                    list.add(matrix[i][j--]);
                }
            } else {
                if (i == top) {
                    list.add(matrix[i][j++]);
                    left++;
                    flag = 1;
                } else {
                    list.add(matrix[i--][j]);
                }
            }
        }
        return list;
    }

    private static List<Integer> spiralMatrix3(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0;
        int y = 0;
        int dy = 1;
        int dx = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = -101;
            if (!(0 <= y + dy && y + dy < cols && 0 <= x + dx && x + dx < rows) || matrix[x + dx][y + dy] == -101) {
                int temp = dy;
                dy = -dx;
                dx = temp;
            }
            y += dy;
            x += dx;
        }
        return res;
    }
}
