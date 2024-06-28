import java.util.Scanner;
import java.util.Stack;

public class MaximumNestingDepthoftheParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(maximumNestingDepthoftheParentheses1(input));
        System.out.println(maximumNestingDepthoftheParentheses2(input));
        System.out.println(maximumNestingDepthoftheParentheses3(input, 0, 0));
    }

    private static int maximumNestingDepthoftheParentheses1(String s) {
        int max = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            }
            if (stack.size() > max) {
                max = stack.size();
            }
        }
        return max;
    }

    private static int maximumNestingDepthoftheParentheses2(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    private static int maximumNestingDepthoftheParentheses3(String s, int count, int max) {
        if (s == null || s.isEmpty()) {
            return max;
        } else if (s.charAt(0) == '(') {
            count++;
        } else if (s.charAt(0) == ')') {
            count--;
        }
        if (count > max) {
            max = count;
        }
        return maximumNestingDepthoftheParentheses3(s.substring(1), count, max);
    }
}
