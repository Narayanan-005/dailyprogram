public class FloodFill {
    public static void main(String[] args) {
        printResult(floodFill1(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
    }

    private static void printResult(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        rec(image, sr, sc, image[sr][sc], color, new boolean[image.length][image[0].length]);
        return image;
    }

    private static void rec(int[][] image, int r, int c, int src, int color, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || visited[r][c] || image[r][c] != src) {
            return;
        }
        image[r][c] = color;
        visited[r][c] = true;
        rec(image, r + 1, c, src, color, visited);
        rec(image, r - 1, c, src, color, visited);
        rec(image, r, c + 1, src, color, visited);
        rec(image, r, c - 1, src, color, visited);
    }

}
