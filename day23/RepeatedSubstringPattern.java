import java.util.Scanner;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        printResult(repeatedSubstringPattern1(input));
        printResult(repeatedSubstringPattern2(input));
        printResult(repeatedSubstringPattern3(input));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("The given String has Repeated substring");
        } else {
            System.out.println("The given String not have Repeated substring");
        }
    }

    private static boolean repeatedSubstringPattern1(String s) {
        int l = s.length();
        boolean flag = false;
        for (int i = 1; i <= l / 2; i++) {
            if (l % i == 0) {
                String temp = s;
                if (temp.replaceAll(s.substring(0, i), "").isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean repeatedSubstringPattern2(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }

    private static boolean repeatedSubstringPattern3(String s) {
        char[] c = s.toCharArray();
        int i = 1, j = 0, n = c.length;
        int[] lps = new int[n + 1];
        while (i < n) {
            if (c[i] == c[j])
                lps[++i] = ++j;
            else if (j == 0)
                i++;
            else
                j = lps[j];
        }
        return lps[n] != 0 && lps[n] % (n - lps[n]) == 0;
    }
}
