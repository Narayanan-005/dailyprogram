import java.util.Scanner;

public class Factorial1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("The Factorial is : "+factorial);
    }
}
