import java.util.Scanner;

public class ReverseVowelsofaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(reverseVowelsofaString1(str));
        System.out.println(reverseVowelsofaString2(str));
        System.out.println(reverseVowelsofaString3(str));
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
            return true;
        }
        return false;
    }

    private static String reverseVowelsofaString1(String s) {
        String vow = "";
        char ch;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (isVowel(ch)) {
                vow += ch;
            }
        }
        for (int i = 0, j = vow.length() - 1; i < s.length(); i++) {
            ch = s.charAt(i);
            if (isVowel(ch)) {
                res += vow.charAt(j--);
            } else {
                res += ch;
            }
        }
        return res;
    }

    private static String reverseVowelsofaString2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            while (i < j && !isVowel(sb.charAt(i))) {
                i++;
            }
            while (i < j && !isVowel(sb.charAt(j))) {
                j--;
            }
            if (i < j) {
                char ch = sb.charAt(i);
                sb.replace(i, i + 1, "" + sb.charAt(j));
                sb.replace(j, j + 1, "" + ch);
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    private static String reverseVowelsofaString3(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            while (i < j && !isVowel(ch[i])) {
                i++;
            }
            while (i < j && !isVowel(ch[j])) {
                j--;
            }
            if (i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        return new String(ch);
    }
}
