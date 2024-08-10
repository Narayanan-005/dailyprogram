public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString1("3[a]2[bc]"));
        System.out.println(decodeString2("3[a]2[bc]"));
    }

    private static String decodeString1(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = false;
        int start = -1;
        int end = -1;
        while (true) {
            found = false;
            start = -1;
            end = -1;
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == '[') {
                    start = i;
                }
                if (ch == ']') {
                    end = i;
                }
                if (start != -1 && end != -1) {
                    while (--start >= 0) {
                        if (!Character.isDigit(sb.charAt(start))) {
                            break;
                        }
                    }
                    start++;
                    sb = sb.replace(start, start + (end - start + 1), get(sb.toString(), start, end));
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return sb.toString();
    }

    private static String get(String s, int start, int end) {
        int n = 0;
        while (true) {
            char ch = s.charAt(start);
            if (Character.isDigit(ch)) {
                n = (n * 10) + (ch - '0');
            } else {
                break;
            }
            start++;
        }
        return s.substring(start + 1, end).repeat(n);
    }

    static int i = 0;

    private static String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = "";
        int num = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            i++;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                temp = decodeString2(s);
                while (num > 0) {
                    sb.append(temp);
                    num--;
                }
            } else if (ch == ']') {
                break;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
