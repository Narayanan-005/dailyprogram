public class CountingWordsWithaGivenPrefix {
    public static void main(String[] args) {
        System.out.println(countingWordsWithaGivenPrefix1(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(countingWordsWithaGivenPrefix2(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(countingWordsWithaGivenPrefix3(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

    private static int countingWordsWithaGivenPrefix1(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    private static int countingWordsWithaGivenPrefix2(String[] words, String pref) {
        int count = 0;
        int l = pref.length();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= l && words[i].substring(0, l).equals(pref)) {
                count++;
            }
        }
        return count;
    }

    private static int countingWordsWithaGivenPrefix3(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (startsWith(words[i], pref)) {
                count++;
            }
        }
        return count;
    }

    private static boolean startsWith(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
