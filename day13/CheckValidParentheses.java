import java.util.Scanner;
import java.util.Stack;

public class CheckValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        printResult(checkValidParentheses1(input));
        printResult(checkValidParentheses2(input));
        printResult(checkValidParentheses3(input));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("The given parentheses is valid");
        } else {
            System.out.println("The given parentheses is not valid");
        }
    }

    private static boolean checkValidParentheses1(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.empty() || (ch == ')' && stack.peek() != '(') || (ch == '}' && stack.peek() != '{') || (ch == ']' && stack.peek() != '[')) {
                return false;
            } else {
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    private static boolean checkValidParentheses2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                sb.append(ch);
            } else if (sb.isEmpty() || (ch == ')' && sb.charAt(sb.length() - 1) != '(') || (ch == '}' && sb.charAt(sb.length() - 1) != '{') || (ch == ']' && sb.charAt(sb.length() - 1) != '[')) {
                return false;
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (!sb.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean checkValidParentheses3(String str) {
        char[] stack = new char[str.length()];
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++index] = ch;
            } else if (index == -1 || (ch == ')' && stack[index] != '(') || (ch == '}' && stack[index] != '{') || (ch == ']' && stack[index] != '[')) {
                return false;
            } else {
                stack[index--] = ' ';
            }
        }
        if (index != -1) {
            return false;
        }
        return true;
    }
}
