import java.util.Scanner;

public class PrimeNumber3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1 || n == 0) {
            System.out.println(n + " is Neither Prime Nor Composite ");
        } else if (isPrime(n, (int) Math.sqrt(n))) {
            System.out.println(n + " is Prime Number");
        } else {
            System.out.println(n + " is Not a Prime Number");
        }
    }

    public static boolean isPrime(int n, int divisor) {
        if (divisor == 1) {
            return true;
        } else if (n % divisor == 0) {
            return false;
        }
        return isPrime(n,divisor-1);
    }
}
