public class LongestNiceSubstring {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring1("YazaAay"));
        System.out.println(longestNiceSubstring2("YazaAay"));
    }

    private static String longestNiceSubstring1(String s) {
        String res = "";
        int l = s.length();
        for (int i = 0; i < l; i++) {
            for (int j = l - 1; j >= 0; j--) {
                if (isNice(s, i, j)) {
                    if (res.length() < j - i + 1) {
                        res = s.substring(i, j + 1);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private static boolean isNice(String s, int i, int j) {
        int caps[] = new int[26];
        int small[] = new int[26];
        for (int k = i; k <= j; k++) {
            char ch = s.charAt(k);
            if (ch >= 'a' && ch <= 'z') {
                small[ch - 'a']++;
            } else {
                caps[ch - 'A']++;
            }
        }
        for (int k = 0; k < 26; k++) {
            if ((caps[k] != 0 && small[k] == 0) || (caps[k] == 0 && small[k] != 0)) {
                return false;
            }
        }
        return true;
    }

    private static String longestNiceSubstring2(String s) {
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c) && s.contains(Character.toUpperCase(c)+"")) continue;
            else if(Character.isUpperCase(c) && s.contains(Character.toLowerCase(c)+"")) continue;
            String left = "", right = "";
            left = longestNiceSubstring2(s.substring(0,i));
            right = longestNiceSubstring2(s.substring(i+1));
            return left.length() >= right.length() ? left : right;
        }
        return s;
    }
}
