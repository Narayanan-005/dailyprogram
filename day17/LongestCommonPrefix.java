import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(input));
        System.out.println(longestCommonPrefix2(input));
        System.out.println(longestCommonPrefix3(input));
    }

    public static String longestCommonPrefix1(String[] strs) {
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || prefix.charAt(i) != strs[j].charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        int l = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            if (ch == strs[l - 1].charAt(i)) {
                res.append(ch);
            } else {
                break;
            }
        }
        return res.toString();
    }
}
