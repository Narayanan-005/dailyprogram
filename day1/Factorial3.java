import java.util.Arrays;
import java.util.Scanner;

public class Factorial3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n + 1];
        Arrays.fill(arr,1);
        for(int i = 1;i<=n;i++){
            arr[i] = arr[i-1]*i;
        }
        System.out.println("The Factorial is : "+arr[n]);
    }
}
