import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstuniquecharacterinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(firstuniquecharacterinaString1(str));
        System.out.println(firstuniquecharacterinaString2(str));
        System.out.println(firstuniquecharacterinaString3(str));
    }

    private static int firstuniquecharacterinaString1(String str) {
        Map<Character, Integer> map = new HashMap();
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int firstuniquecharacterinaString2(String str) {
        int count[] = new int[26];
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int firstuniquecharacterinaString3(String str) {
        int count[] = new int[26];
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i] - 'a'] == 0) {
                if (str.indexOf(arr[i], i + 1) == -1) {
                    return i;
                }
            }
            count[arr[i] - 'a']++;
        }
        return -1;
    }
}
