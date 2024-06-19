import java.util.Scanner;

public class FirstOccurrenceIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();
        System.out.println(firstOccurrenceIndex1(input1, input2));
        System.out.println(firstOccurrenceIndex2(input1, input2));
        System.out.println(firstOccurrenceIndex3(input1, input2));
    }

    private static int firstOccurrenceIndex1(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return -1;
        }
        int l = str2.length();
        for (int i = 0; i <= str1.length() - l; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                int j = i, k = 0;
                while (k < str2.length() && str1.charAt(j) == str2.charAt(k)) {
                    k++;
                    j++;
                }
                if (k == str2.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int firstOccurrenceIndex2(String str1, String str2) {
        return str1.indexOf(str2);
    }

    private static int firstOccurrenceIndex3(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return -1;
        }
        int l = str2.length();
        for (int i = 0; i <= str1.length() - l; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                if (str1.substring(i, i + l).equals(str2)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
