import java.util.Scanner;

public class PyramidPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        pyramidPattern1(n);
        System.out.println();
        pyramidPattern2(n);
        System.out.println();
        pyramidPattern3(n);
    }

    private static void pyramidPattern1(int n) {
        int currentNum = 1;
        for (int row = 1; currentNum <= n; row++) {
            for (int space = n - row; space > 0; space--) {
                System.out.print(" ");
            }
            for (int num = 0; num < row && currentNum <= n; num++) {
                System.out.print(currentNum + " ");
                currentNum++;
            }
            System.out.println();
        }
    }

    private static void pyramidPattern2(int n) {
        int num = 1;
        int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2);
        for (int i = 0; i < rows && num <= n; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1 && num <= n; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    private static void pyramidPattern3(int n) {
        int num = 1;
        int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2);
        for (int i = 0; i < rows && num <= n; i++) {
            System.out.print(" ".repeat(rows - i - 1));
            for (int j = 0; j < i + 1 && num <= n; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
