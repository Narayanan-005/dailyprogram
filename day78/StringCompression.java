public class StringCompression {
    public static void main(String[] args) {
        System.out.println(stringCompression1(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(stringCompression2(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    private static int stringCompression1(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int i = 1;
        for (; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                sb.append(chars[i - 1]);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        sb.append(chars[i - 1]);
        if (count > 1) {
            sb.append(count);
        }
        i = 0;
        for (; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

    private static int stringCompression2(char[] chars) {
        int i = 1, j = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[j++] = chars[i - 1];
                if (count > 1) {
                    sb.append(count);
                    for (char ch : sb.toString().toCharArray()) {
                        chars[j++] = ch;
                    }
                    count = 1;
                    sb.setLength(0);
                }
                continue;
            }
            if (chars[i] == chars[i - 1]) {
                count++;
            }
        }
        return j;
    }
}
