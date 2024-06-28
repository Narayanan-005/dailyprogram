import java.util.Scanner;

public class RemovePalindromeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(removePalindromeWords1(input));
        System.out.println(removePalindromeWords2(input));
        System.out.println(removePalindromeWords3(input));
    }

    private static String removePalindromeWords1(String word) {
        String[] strs = word.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (!isPalindrome(strs[i])) {
                builder.append(strs[i]);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    private static boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private static String removePalindromeWords2(String word) {
        String[] strs = word.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (isPalindrome(strs[i])) {
                strs[i] = "";
            }
        }
        return String.join(" ", String.join(" ", strs).split("\\s+"));
    }

    private static String removePalindromeWords3(String word) {
        StringBuilder builder = new StringBuilder(word);
        for (int i = 0; i < builder.length(); i++) {
            if (!Character.isAlphabetic(builder.charAt(i))) {
                continue;
            }
            int start = i;
            int end = builder.indexOf(" ", start);
            if (end == -1) {
                end = builder.length();
            }
            if (isPalindrome(builder.substring(start, end))) {
                builder.replace(start, end + 1, "");
                i--;
            } else {
                i += end - start;
            }
        }
        return builder.toString().trim();
    }
}
