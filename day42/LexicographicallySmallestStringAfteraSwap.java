public class LexicographicallySmallestStringAfteraSwap {
    public static void main(String[] args) {
        System.out.println(lexicographicallySmallestStringAfteraSwap1("45320"));
        System.out.println(lexicographicallySmallestStringAfteraSwap2("45320"));
        System.out.println(lexicographicallySmallestStringAfteraSwap3("45320"));
    }

    private static String lexicographicallySmallestStringAfteraSwap1(String s) {
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == (s.charAt(i - 1) - '0') % 2 && s.charAt(i - 1) > s.charAt(i)) {
                s = s.substring(0, i - 1) + s.charAt(i) + s.charAt(i - 1) + s.substring(i + 1);
                break;
            }
        }
        return s;
    }

    private static String lexicographicallySmallestStringAfteraSwap2(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < s.length(); i++) {
            if ((sb.charAt(i) - '0') % 2 == (sb.charAt(i - 1) - '0') % 2 && sb.charAt(i - 1) > sb.charAt(i)) {
                char ch = sb.charAt(i - 1);
                sb.replace(i - 1, i, "" + sb.charAt(i));
                sb.replace(i, i + 1, "" + ch);
                break;
            }
        }
        return sb.toString();
    }

    private static String lexicographicallySmallestStringAfteraSwap3(String s) {
        char ch[] = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if ((ch[i] - '0') % 2 == (ch[i - 1] - '0') % 2 && ch[i - 1] > ch[i]) {
                char temp = ch[i - 1];
                ch[i - 1] = ch[i];
                ch[i] = temp;
                break;
            }
        }
        return new String(ch);
    }
}
