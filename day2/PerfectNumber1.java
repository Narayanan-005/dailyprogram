import java.util.Scanner;

public class PerfectNumber1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (isPerfectNumber(n)) {
            System.out.println("The Given Number is Perfect Number");
        } else {
            System.out.println("The Given Number is Not a Perfect Number");
        }
    }

    public static boolean isPerfectNumber(int n) {
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
