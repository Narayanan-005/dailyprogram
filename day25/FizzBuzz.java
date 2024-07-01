import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fizzBuzz1(n));
        System.out.println(fizzBuzz2(n));
        System.out.println(fizzBuzz3(n));
    }

    private static List<String> fizzBuzz1(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    private static List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            StringBuilder res = new StringBuilder();
            if (i % 3 == 0) {
                res.append("Fizz");
            }
            if (i % 5 == 0) {
                res.append("Buzz");
            }
            if (res.isEmpty()) {
                res.append(i);
            }
            list.add(res.toString());
        }
        return list;
    }

    private static List<String> fizzBuzz3(int n) {
        String arr[] = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                arr[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                arr[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                arr[i - 1] = "Buzz";
            } else {
                arr[i - 1] = String.valueOf(i);
            }
        }
        return Arrays.asList(arr);
    }
}
