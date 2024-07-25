import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(removeOutermostParentheses1("(()())(())"));
        System.out.println(removeOutermostParentheses2("(()())(())"));
    }

    private static String removeOutermostParentheses1(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (stack.isEmpty()) {
                    stack.push('(');
                    continue;
                }
                stack.push('(');
            } else if (ch == ')') {
                if (stack.size() == 1) {
                    stack.pop();
                    continue;
                }
                stack.pop();
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private static String removeOutermostParentheses2(String s) {

        int count = 0;
        char arr[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(') {
                if (count == 0) {
                    count++;
                    continue;
                }
                count++;
            } else if (ch == ')') {
                if (count == 1) {
                    count--;
                    continue;
                }
                count--;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
