import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lucky Number");
        int lucky = scanner.nextInt();
        System.out.println("Enter Limit");
        int limit = scanner.nextInt();
        luckyNumber1(lucky, limit);
        System.out.println();
        luckyNumber2(lucky, limit);
        System.out.println();
        luckyNumber3(lucky, limit);
    }

    public static void luckyNumber1(int lucky, int limit) {
        for (int i = 1; i <= limit; i++) {
            if (isLucky(i, lucky)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isLucky(int n, int lucky) {
        while (n > 0) {
            if (n % 10 == lucky) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    public static void luckyNumber2(int lucky, int limit) {
        if (limit == 0) {
            return;
        }
        luckyNumber2(lucky, limit - 1);
        if (isLuckyRec(limit, lucky)) {
            System.out.print(limit + " ");
        }
    }

    public static boolean isLuckyRec(int n, int lucky) {
        if (n == 0) {
            return false;
        } else if (n % 10 == lucky) {
            return true;
        }
        return isLuckyRec(n / 10, lucky);
    }

    public static void luckyNumber3(int lucky, int limit) {
        String strLucky = String.valueOf(lucky);
        for (int i = 1; i <= limit; i++) {
            if (String.valueOf(i).contains(strLucky)) {
                System.out.print(i + " ");
            }
        }
    }
}
