public class TheCelebrityProblem {
    public static void main(String[] args) {
        int mat[][] = {{0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}};
        System.out.println(theCelebrityProblem1(mat));
        System.out.println(theCelebrityProblem2(mat));
        System.out.println(theCelebrityProblem3(mat));
    }

    private static int theCelebrityProblem1(int mat[][]) {
        int l = mat.length;
        for (int i = 0; i < l; i++) {
            if (isCelebrity(mat, i, l)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isCelebrity(int[][] mat, int celebrity, int l) {
        for (int i = 0; i < l; i++) {
            if (i != celebrity && mat[i][celebrity] == 0) {
                return false;
            }
            if (mat[celebrity][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static int theCelebrityProblem2(int mat[][]) {
        int l = mat.length;
        int[] count = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (mat[i][j] == 1) {
                    if (i != j)
                        count[j]++;
                    count[i]--;

                }
            }
        }
        for (int i = 0; i < l; i++) {
            if (count[i] == l - 1) {
                return i;
            }
        }
        return -1;
    }

    private static int theCelebrityProblem3(int[][] mat) {
        int n = mat.length;
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (mat[a][b] == 1)
                a++;
            else
                b--;
        }
        for (int i = 0; i < n; i++) {
            if ((i != a) && (mat[a][i] == 1 || mat[i][a] == 0)) return -1;
        }
        return a;
    }

}
