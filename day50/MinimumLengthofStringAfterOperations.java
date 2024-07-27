import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumLengthofStringAfterOperations {
    public static void main(String[] args) {
        System.out.println(minimumLengthofStringAfterOperations1("abaacbcbb"));
        System.out.println(minimumLengthofStringAfterOperations2("abaacbcbb"));
        System.out.println(minimumLengthofStringAfterOperations3("abaacbcbb"));
    }

    private static int minimumLengthofStringAfterOperations1(String s) {
        int l = s.length();
        int res = l;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            }
            int count = 1;
            int j = i + 1;
            char ch = s.charAt(i);
            while (j < l) {
                if (ch == s.charAt(j++)) {
                    count++;
                }
            }
            res -= ((count - 1) / 2) * 2;
            set.add(ch);
        }
        return res;
    }

    private static int minimumLengthofStringAfterOperations2(String s) {
        int l = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            l -= ((entry.getValue() - 1) / 2) * 2;
        }
        return l;
    }

    private static int minimumLengthofStringAfterOperations3(String s) {
        int[] count = new int[26];
        int l = s.length();
        for (int i = 0; i < l; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            l -= ((count[i] - 1) / 2) * 2;
        }
        return l;
    }
}
