import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(characterCount1(input, 1));
        System.out.println(characterCount2(input));
        System.out.println(characterCount3(input));
    }

    public static String characterCount1(String str, int count) {
        if (str.isEmpty()) {
            return "";
        } else if (str.length() == 1) {
            return str.charAt(0) + "" + count;
        } else if (str.charAt(0) == str.charAt(1)) {
            return characterCount1(str.substring(1), count + 1);
        }
        return str.charAt(0) + "" + count + characterCount1(str.substring(1), 1);
    }

    public static String characterCount2(String str) {
        int occurence[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            occurence[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (occurence[i] != 0) {
                builder.append((char) (97 + i) + "" + occurence[i]);
            }
        }
        return builder.toString();
    }

    public static String characterCount3(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        int i = 1;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                builder.append(str.charAt(i - 1) + "" + count);
                count = 1;
            }
        }
        builder.append(str.charAt(i - 1) + "" + count);
        return builder.toString();
    }
}
