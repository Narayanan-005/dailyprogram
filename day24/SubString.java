import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "test123string";
        String s2 = "123";
        System.out.println(subString1(s1, s2));
        System.out.println(subString2(s1, s2));
        System.out.println(subString3(s1, s2));
    }

    private static int subString1(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l2 > l1) {
            return -1;
        }
        for (int i = 0; i < l1 - l2 + 1; i++) {
            int j = 0;
            for (; j < l2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }

    private static int subString2(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l2 > l1) {
            return -1;
        }
        for (int i = 0; i < l1 - l2 + 1; i++) {
            if (str1.substring(i, i + l2).equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    private static int subString3(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l2 > l1) {
            return -1;
        }
        for (int i = 0, j = 0; i < l1; i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            if (j == l2 - 1) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
