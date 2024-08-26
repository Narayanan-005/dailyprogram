public class SeparatetheNumbers {
    public static void main(String[] args) {
        separatetheNumbers1("91011");
    }

    private static void separatetheNumbers1(String s) {
        String res = returnRes(s);
        if (res.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES " + res);
        }
    }

    public static String returnRes(String s) {
        int n = s.length();
        for (int i = 1; i*2 <= n; i++) {
            String first = s.substring(0, i);
            try {
                long num = Long.parseLong(first);
                int j = i;
                while (j < n) {
                    String next = Long.toString(num + 1);
                    if (!s.startsWith(next, j)) { break; }
                    num++;
                    j += next.length();
                }
                if (j == n) { return first; }
            } catch (Exception e) {}
        }
        return "";
    }

}
