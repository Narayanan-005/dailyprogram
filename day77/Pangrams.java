import java.util.HashSet;
import java.util.Set;

public class Pangrams {
    public static void main(String[] args) {
        System.out.println("The given string is " + pangrams1("We promptly judged antique ivory buckles for the next prize"));
        System.out.println("The given string is " + pangrams2("We promptly judged antique ivory buckles for the next prize"));
        System.out.println("The given string is " + pangrams3("We promptly judged antique ivory buckles for the next prize"));
    }

    private static String pangrams1(String s) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (s.indexOf(ch) == -1 && s.indexOf((char) (ch + 32)) == -1) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    private static String pangrams2(String s) {
        int arr[] = new int[26];
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            } else {
                arr[ch - 'A']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    private static String pangrams3(String s) {
        s = s.toLowerCase();
        if (s.length() < 26) {
            return "not pangram";
        }
        Set<Character> set = new HashSet();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            set.add(ch);
        }
        if (set.size() == 26) {
            return "pangram";
        }
        return "not pangram";
    }
}
