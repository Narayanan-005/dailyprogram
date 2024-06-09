import java.util.Scanner;

public class Anagram1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        if (isAnagram(str1, str2)) {
            System.out.println("The Given String is Anagram");
        } else {
            System.out.println("The Given String is Not Anagram");
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str2);
        for (int i = 0; i < str1.length(); i++) {
            int index = sb.indexOf("" + str1.charAt(i));
            if (index == -1) {
                return false;
            }
            sb.deleteCharAt(index);
        }
        if (sb.isEmpty()) {
            return true;
        }
        return false;
    }
}
