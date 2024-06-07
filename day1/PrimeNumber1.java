import java.util.Scanner;

public class PrimeNumber1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1 || n == 0) {
            System.out.println(n + " is Neither Prime Nor Composite ");
        } else if (isPrime(n)) {
            System.out.println(n + " is Prime Number");
        } else {
            System.out.println(n + " is Not a Prime Number");
        }
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
}
