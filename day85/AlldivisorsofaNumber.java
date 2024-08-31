import java.util.ArrayList;
import java.util.List;

public class AlldivisorsofaNumber {
    public static void main(String[] args) {
        alldivisorsofaNumber1(20);
        System.out.println();
        alldivisorsofaNumber2(20);
    }

    private static void alldivisorsofaNumber1(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print(n);
    }

    private static void alldivisorsofaNumber2(int n) {
        List<Integer> al = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            if (n % i == 0) {
                if (i == n / i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    al.add(n / i);
                }
            }
            i += 1;
        }
        for (int j = al.size() - 1; j >= 0; j--)
            System.out.print(al.get(j) + " ");
    }
}
