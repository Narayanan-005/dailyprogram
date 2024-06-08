import java.util.Scanner;

public class PerfectNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (isPerfectNumber(n, 0, n / 2)) {
            System.out.println("The Given Number is Perfect Number");
        } else {
            System.out.println("The Given Number is Not a Perfect Number");
        }
    }

    public static boolean isPerfectNumber(int num, int sum, int decrement) {
        if (sum == num) {
            return true;
        } else if (decrement == 0) {
            return false;
        }
        if (num % decrement == 0) {
            sum += decrement;
        }
        return isPerfectNumber(num, sum, --decrement);
    }
}
