import java.util.Scanner;

public class LargestOddNumberinString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(largestOddNumberinString1(input));
        System.out.println(largestOddNumberinString2(input));
        System.out.println(largestOddNumberinString3(input));
    }

    private static String largestOddNumberinString1(String num) {
        int index = -1;
        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                index = i;
            }
        }
        if (index != -1) {
            return num.substring(0, index + 1);
        }
        return "";
    }

    private static String largestOddNumberinString2(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    private static String largestOddNumberinString3(String num) {
        if (num.isEmpty()) {
            return "";
        } else if ((num.charAt(num.length() - 1) - '0') % 2 == 1) {
            return num;
        }
        return largestOddNumberinString3(num.substring(0, num.length() - 1));
    }
}
