import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        result(isHappyNumber1(n));
        result(isHappyNumber2(n));
        result(isHappyNumber3(n));
    }

    public static void result(boolean status) {
        if (status) {
            System.out.println("The Given Number is Happy Number");
        } else {
            System.out.println("The Given Number is Not a Happy Number");
        }
    }

    public static boolean isHappyNumber1(int n) {
        Set<Integer> set = new HashSet();
        set.add(n);
        int temp = 0;
        while (n != 1) {
            temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public static boolean isHappyNumber2(int n) {
        int sum = squreSum(n);
        if (sum <= 5) {
            return sum == 1;
        }
        return isHappyNumber2(sum);
    }

    public static int squreSum(int n) {
        if (n == 0) {
            return 0;
        }
        return ((n % 10) * (n % 10)) + squreSum(n / 10);
    }

    public static boolean isHappyNumber3(int n) {
        int temp = 0;
        do {
            temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
        } while (n > 5);
        return temp == 1;
    }
}
