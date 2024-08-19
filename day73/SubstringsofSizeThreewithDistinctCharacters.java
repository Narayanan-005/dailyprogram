public class SubstringsofSizeThreewithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(substringsofSizeThreewithDistinctCharacters1("aababcabc"));
        System.out.println(substringsofSizeThreewithDistinctCharacters2("aababcabc"));
    }

    private static int substringsofSizeThreewithDistinctCharacters1(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (isGood(s, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isGood(String str, int i) {
        char f = str.charAt(i), s = str.charAt(i + 1), t = str.charAt(i + 2);
        return f != s && f != t && s != t;
    }

    private static int substringsofSizeThreewithDistinctCharacters2(String s) {
        if (s.length() < 3) {
            return 0;
        }
        char f = s.charAt(0), se = s.charAt(1), t = ' ';
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            t = s.charAt(i);
            if (f != se && se != t && f != t) {
                count++;
            }
            f = se;
            se = t;
        }
        return count;
    }
}
