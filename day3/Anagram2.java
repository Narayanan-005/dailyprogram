import java.util.Scanner;

public class Anagram2 {
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
        int occurence[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            occurence[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            occurence[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (occurence[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
