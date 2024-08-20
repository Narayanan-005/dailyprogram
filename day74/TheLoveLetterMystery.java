public class TheLoveLetterMystery {
    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery1("cde"));
        System.out.println(theLoveLetterMystery2("cde"));
        System.out.println(theLoveLetterMystery3("cde", 0));
    }

    private static int theLoveLetterMystery1(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += Math.abs(s.charAt(i) - sb.charAt(i));
        }
        return count / 2;
    }

    private static int theLoveLetterMystery2(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        int i = 0, j = ch.length - 1;
        while (i < j) {
            count += Math.abs(ch[i++] - ch[j--]);
        }
        return count;
    }

    private static int theLoveLetterMystery3(String s, int ind) {
        if (ind >= s.length() / 2) {
            return 0;
        }
        return Math.abs(s.charAt(ind) - s.charAt(s.length() - 1 - ind)) + theLoveLetterMystery3(s, ind + 1);
    }
}
