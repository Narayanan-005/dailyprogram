import java.util.Scanner;

public class PrimeNumber2 {
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
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
