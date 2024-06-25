import java.util.Scanner;

public class PrintDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printDiamond1(n);
        System.out.println();
        printDiamond2(n);
        System.out.println();
        printDiamond3(n, 0, n - 1);
    }

    private static void printDiamond1(int n) {
        int space = n - 1;
        int iteration = n + (n - 1);
        for (int i = 0; i < iteration; i++) {
            int temp = space;
            while (temp-- > 0)
                System.out.print(" ");
            temp = n - space;
            while (temp-- > 0)
                System.out.print("* ");
            if (i < n - 1) {
                space--;
            } else {
                space++;
            }
            System.out.println();
        }
    }

    private static void printDiamond2(int n) {
        int space = n - 1;
        int iteration = n + (n - 1);
        for (int i = 0; i < iteration; i++) {
            System.out.print(" ".repeat(space));
            System.out.print("* ".repeat(n - space));
            if (i < n - 1) {
                space--;
            } else {
                space++;
            }
            System.out.println();
        }
    }

    private static void printDiamond3(int n, int iterarion, int space) {
        if (iterarion == n + (n - 1)) {
            return;
        }
        System.out.print(" ".repeat(space));
        System.out.print("* ".repeat(n - space));
        System.out.println();
        if (iterarion < n - 1)
            printDiamond3(n, iterarion + 1, space - 1);
        else
            printDiamond3(n, iterarion + 1, space + 1);
    }

}
