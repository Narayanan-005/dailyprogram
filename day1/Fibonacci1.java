import java.util.Scanner;

public class Fibonacci1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = 0;
        int n2 = 1;
        int n3;
        if (n >= 1) {
            System.out.print(n1 + " ");
        }
        if (n >= 2) {
            System.out.print(n2 + " ");
        }
        if (n >= 3) {
            for(int i = 3; i <= n; i++){
                n3 = n1+n2;
                System.out.print(n3+" ");
                n1 = n2;
                n2 = n3;
            }
        }
    }
}
