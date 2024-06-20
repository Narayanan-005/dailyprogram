import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        printResult(wordPattern1(pattern, s));
        printResult(wordPattern2(pattern, s));
        printResult(wordPattern3(pattern, s));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("The words and pattern matches");
        } else {
            System.out.println("The words and pattern does not matches");
        }
    }

    private static boolean wordPattern1(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            } else {
                map.put(ch, strs[i]);
            }
        }
        return true;
    }

    private static boolean wordPattern2(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) {
                    return false;
                }
            } else {
                map.put(ch, strs[i]);
            }
        }
        Set<String> words = new HashSet(map.values());
        return map.size() == words.size();
    }

    private static boolean wordPattern3(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        String[] words = new String[26];
        Set<String> set = new HashSet();
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (words[ch - 'a'] != null) {
                if (!words[ch - 'a'].equals(strs[i])) {
                    return false;
                }
            } else if (set.contains(strs[i])) {
                return false;
            }
            words[ch - 'a'] = strs[i];
            set.add(strs[i]);
        }
        return true;
    }
}
