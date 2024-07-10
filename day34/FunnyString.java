import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(funnyString1(input));
        System.out.println(funnyString2(input));
        System.out.println(funnyString3(input));
    }

    private static String funnyString1(String s) {
        int l = s.length();
        int[] a = new int[l - 1], b = new int[l - 1];
        for (int i = 0; i < l - 1; i++) {
            a[i] = Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        for (int i = l - 1, j = 0; i > 0; i--) {
            b[j++] = Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        for (int i = 0; i < l - 1; i++) {
            if (a[i] != b[i]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    private static String funnyString2(String s) {
        int l = s.length();
        for (int i = 0, j = l - 1; i < l - 1; i++, j--) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != Math.abs(s.charAt(j) - s.charAt(j - 1))) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    private static String funnyString3(String s) {
        int l = s.length();
        if (l < 3) {
            return "Funny";
        }
        if (Math.abs(s.charAt(0) - s.charAt(1)) != Math.abs(s.charAt(l - 1) - s.charAt(l - 2))) {
            return "Not Funny";
        }
        return funnyString3(s.substring(1, l - 1));
    }
}
