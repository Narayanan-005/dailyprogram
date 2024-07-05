import java.util.Scanner;

public class PalindromeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        palindromeIndex1(input);
        palindromeIndex2(input);
    }

    private static int palindromeIndex1(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (isPalindrome(s.substring(0, j) + s.substring(j + 1))) {
                    return j;
                } else if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
                    return i;
                }
                break;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static int palindromeIndex2(String s) {
        int i = 0;
        int j = s.length() - 1;
        int res = -1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (res != -1) {
                    res = -1;
                    break;
                }
                if (s.charAt(i) == s.charAt(j - 1)) {
                    res = j;
                    i++;
                    j -= 2;
                } else if (s.charAt(i + 1) == s.charAt(j)) {
                    res = i;
                    j--;
                    i += 2;
                } else {
                    res = -1;
                    break;
                }
            }
        }
        return res;
    }
}
