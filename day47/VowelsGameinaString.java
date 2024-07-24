import java.util.Scanner;

public class VowelsGameinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printResut(vowelsGameinaString1(str));
        printResut(vowelsGameinaStrin2(str));
    }

    private static void printResut(boolean b) {
        if (b) {
            System.out.println("Alice can win the game");
        } else {
            System.out.println("Alice can't win the game");
        }
    }

    private static boolean vowelsGameinaString1(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }

    private static boolean vowelsGameinaStrin2(String s) {
        return s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u");
    }
}
