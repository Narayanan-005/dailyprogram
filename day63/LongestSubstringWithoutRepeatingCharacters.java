import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters1("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters2("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters3("abcabcbb"));
    }

    private static int longestSubstringWithoutRepeatingCharacters1(String s) {
        int output = 0;
        StringBuilder sub = new StringBuilder();
        String arr[] = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if (sub.indexOf(arr[i]) == -1) {
                sub.append(arr[i]);
            } else {
                i = i - sub.length();
                output = Math.max(output, sub.length());
                sub.setLength(0);
            }
        }
        output = Math.max(output, sub.length());
        return output;
    }

    private static int longestSubstringWithoutRepeatingCharacters2(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; ) {
            if (!set.contains(ch[i])) {
                set.add(ch[i++]);
                max = Math.max(max, set.size());
            } else {
                set.remove(ch[i - set.size()]);
            }
        }
        return max;
    }

    private static int longestSubstringWithoutRepeatingCharacters3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                start = Math.max(start, map.get(ch[i]) + 1);
            }
            map.put(ch[i], i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
