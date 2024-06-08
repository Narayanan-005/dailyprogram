import java.util.Scanner;

public class PerfectNumber3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (isPerfectNumber(n)) {
            System.out.println("The Given Number is Perfect Number");
        } else {
            System.out.println("The Given Number is Not a Perfect Number");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfectNumber(int number) {
        for (int p = 2; p <= Math.sqrt(number) + 1; p++) {
            if (isPrime(p)) {
                int mersennePrime = (1 << p) - 1;
                if (isPrime(mersennePrime)) {
                    int perfectNumber = (1 << (p - 1)) * mersennePrime;
                    if (perfectNumber == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
