import java.util.Scanner;

public class MaximumHeightofaTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(maximumHeightofaTriangle1(r, b));
        System.out.println(maximumHeightofaTriangle2(r, b));
    }

    private static int maximumHeightofaTriangle1(int red, int blue) {
        return Math.max(count1(red, blue), count1(blue, red));
    }

    private static int count1(int first, int second) {
        int height = 0;
        int i = 1;
        while (true) {
            if (i % 2 == 1 && first >= i) {
                first -= i++;
                height++;
            } else if (i % 2 == 0 && second >= i) {
                second -= i++;
                height++;
            } else {
                break;
            }
        }
        return height;
    }

    private static int maximumHeightofaTriangle2(int red, int blue) {
        return Math.max(count2(red, blue), count2(blue, red));
    }

    private static int count2(int first, int second) {
        int height = 0;
        int i = 1;
        while (true) {
            if (first >= i) {
                first -= i++;
                height++;
            } else {
                break;
            }
            if (second >= i) {
                second -= i++;
                height++;
            } else {
                break;
            }
        }
        return height;
    }


}
