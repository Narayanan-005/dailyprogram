import java.util.Scanner;
import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(reverseWord1(input));
        System.out.println(reverseWord2(input));
        System.out.println(reverseWord3(input));
    }

    private static String reverseWord1(String str) {
        String[] sp = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < sp.length; i++) {
            stack.push(sp[i]);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String reverseWord2(String str) {
        String[] sp = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            builder.append(sp[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String reverseWord3(String str) {
        int l = str.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; j < l; j++) {
            if (str.charAt(j) == ' ') {
                builder.insert(0, " " + str.substring(i, j));
                i = j + 1;
            } else if (j == l - 1) {
                builder.insert(0, str.substring(i, j + 1));
            }
        }
        return builder.toString();
    }
}
