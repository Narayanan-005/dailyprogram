import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (isStrongNumber1(n)) {
            System.out.println("The given Number is Strong Number");
        } else {
            System.out.println("The given Number is not Strong Number");
        }
        if (n == factorialSum(n)) {
            System.out.println("The given Number is Strong Number");
        } else {
            System.out.println("The given Number is not Strong Number");
        }
        if (isStrongNumber3(n)) {
            System.out.println("The given Number is Strong Number");
        } else {
            System.out.println("The given Number is not Strong Number");
        }
    }

    //first
    public static boolean isStrongNumber1(int n) {
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return n == sum;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int j = 2; j <= n; j++) {
            fact *= j;
        }
        return fact;
    }

    //second
    public static int factorialSum(int n) {
        if (n == 0) {
            return 0;
        }
        return factorialRec(n % 10) + factorialSum(n / 10);
    }

    private static int factorialRec(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }

    //third
    public static boolean isStrongNumber3(int n) {
        int temp = n;
        if (temp < 10) {
            return n == factorial(temp);
        }
        int fact[] = new int[10];
        fact[0] = 1;
        int f = 1;
        for (int i = 1; i <= 9; i++) {
            f *= i;
            fact[i] = f;
        }
        int sum = 0;
        while (temp > 0) {
            sum += fact[temp % 10];
            temp /= 10;
        }
        return sum == n;
    }
}
