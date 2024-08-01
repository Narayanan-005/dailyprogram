public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(longestRepeatingCharacterReplacement1("ABAB", 2));
        System.out.println(longestRepeatingCharacterReplacement2("ABAB", 2));
        System.out.println(longestRepeatingCharacterReplacement3("ABAB", 2));
    }

    private static int longestRepeatingCharacterReplacement1(String s, int k) {
        int max = k;
        int l = s.length();
        for (int i = 0; i < l - k; i++) {
            max = Math.max(max, isValid(s.substring(i), k));
        }
        if (max > l) {
            max = l;
        }
        return max;
    }

    private static int isValid(String s, int k) {
        int max = k;
        int l = s.length();
        int arr[] = new int[26];
        for (int i = 0; i < l; i++) {
            int index = s.charAt(i) - 'A';
            if (++arr[index] + k >= i + 1) {
                max = Math.max(max, arr[index] + k);
            }
        }
        return max;
    }

    private static int longestRepeatingCharacterReplacement2(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while (j < n) {
                if (s.charAt(j) == c) {
                    j++;
                } else if (replaced < k) {
                    j++;
                    replaced++;
                } else if (s.charAt(i) == c) {
                    i++;
                } else {
                    i++;
                    replaced--;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    private static int longestRepeatingCharacterReplacement3(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int max = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);
            if (r - l + 1 - max > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
