public class MaximumScoreAfterSplittingaString {
    public static void main(String[] args) {
        System.out.println(maximumScoreAfterSplittingaString1("011101"));
        System.out.println(maximumScoreAfterSplittingaString2("011101"));
        System.out.println(maximumScoreAfterSplittingaString3("011101"));
    }

    private static int maximumScoreAfterSplittingaString1(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            count = Math.max(count, count(s, i));
        }
        return count;
    }

    private static int count(String s, int mid) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i <= mid && ch == '0') {
                count++;
            } else if (i > mid && ch == '1') {
                count++;
            }
        }
        return count;
    }

    private static int maximumScoreAfterSplittingaString2(String s) {
        int count1 = 0;
        int count0 = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                count1--;
            } else {
                count0++;
            }
            count = Math.max(count, count1 + count0);
        }
        return count;
    }

    private static int maximumScoreAfterSplittingaString3(String s) {
        int l = s.length();
        int zeros[] = new int[l + 1];
        int ones[] = new int[l + 1];
        for (int i = 1; i < l; i++) {
            zeros[i] = zeros[i - 1] + (s.charAt(i - 1) == '0' ? 1 : 0);
            ones[l - i] = ones[l - i + 1] + (s.charAt(l - i) - '0');
        }
        int max = 0;
        for (int i = 1; i < l; i++) {
            max = Math.max(max, zeros[i] + ones[i]);
        }
        return max;
    }
}
