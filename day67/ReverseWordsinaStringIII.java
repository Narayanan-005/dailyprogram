public class ReverseWordsinaStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWordsinaStringIII1("Mr Ding"));
        System.out.println(reverseWordsinaStringIII2("Mr Ding"));
        System.out.println(reverseWordsinaStringIII3("Mr Ding"));
    }

    private static String reverseWordsinaStringIII1(String s) {
        String strs[] = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = getReverse(strs[i]);
        }
        return String.join(" ", strs);
    }

    private static String getReverse(String s) {
        char ch[] = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char temp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
        return new String(ch);
    }

    private static String reverseWordsinaStringIII2(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(temp);
                temp = new StringBuilder();
            } else {
                temp.insert(0, ch);
            }
        }
        if (!sb.isEmpty()) {
            sb.append(" ");
        }
        sb.append(temp);
        return sb.toString();
    }

    private static String reverseWordsinaStringIII3(String s) {
        char ch[] = s.toCharArray();
        for (int i = 0, j = 0; i < ch.length; i++) {
            while (j < ch.length && ch[j] != ' ') {
                j++;
            }
            int r = j - 1;
            while (i < r) {
                char temp = ch[i];
                ch[i++] = ch[r];
                ch[r--] = temp;
            }
            i = j++;
        }
        return new String(ch);
    }
}
