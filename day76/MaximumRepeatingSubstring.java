public class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(maximumRepeatingSubstring1("ababc", "ab"));
        System.out.println(maximumRepeatingSubstring2("ababc", "ab"));
        System.out.println(maximumRepeatingSubstring3("ababc", "ab"));
    }

    private static int maximumRepeatingSubstring1(String sequence, String word) {
        int k = 0;
        if (sequence.length() < word.length()) {
            return k;
        }
        int i = 0;
        while ((i = sequence.indexOf(word, i)) != -1) {
            int max = findRepeat(sequence, i, word);
            k = Math.max(k, max);
            i++;
        }
        return k;
    }

    private static int findRepeat(String seq, int start, String word) {
        int k = 0;
        int pre = start - word.length();
        while ((start = seq.indexOf(word, start)) != -1) {
            if (start - word.length() == pre) {
                pre = start;
                start += word.length();
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    private static int maximumRepeatingSubstring2(String sequence, String word) {
        String res = word;
        while (sequence.contains(res)) {
            res += word;
        }
        return res.length() / word.length() - 1;
    }

    private static int maximumRepeatingSubstring3(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        int maxRepeat = 0;
        for (int i = m; i <= n; i++) {
            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
                maxRepeat = Math.max(maxRepeat, dp[i]);
            }
        }
        return maxRepeat;
    }
}
