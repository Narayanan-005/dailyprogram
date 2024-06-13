import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        printResult(isPalindrome1(input));
        printResult(isPalindrome2(input));
        printResult(isPalindrome3(input));
    }

    private static void printResult(boolean status) {
        if (status) {
            System.out.println("The given String is Palindrome");
        } else {
            System.out.println("The given String is not a Palindrome");
        }
    }

    private static boolean isPalindrome1(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.insert(0, str.charAt(i));
        }
        return builder.toString().equals(str);
    }

    private static boolean isPalindrome2(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPalindrome3(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome3(str.substring(1, str.length() - 1));
    }
}
