import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        System.out.println(clearDigits1("cb34"));
        System.out.println(clearDigits2("cb34"));
        System.out.println(clearDigits3("cb34"));
    }

    private static String clearDigits1(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean status = false;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    sb.replace(i - 1, i + 1, "");
                    status = true;
                    break;
                }
            }
            if (!status) {
                break;
            }
        }
        return sb.toString();
    }

    private static String clearDigits2(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private static String clearDigits3(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.deleteCharAt(i--);
                sb.deleteCharAt(i--);
            }
        }
        return sb.toString();
    }

}
