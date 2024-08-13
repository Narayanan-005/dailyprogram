public class PermutationinString {
    public static void main(String[] args) {
        System.out.println(permutationinString1("ab", "eidbaooo"));
        System.out.println(permutationinString2("ab", "eidbaooo"));
    }

    private static boolean permutationinString1(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i < l2 - l1 + 1; i++) {
            if (contains(s1, s2, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(String s1, String s2, int ind) {
        int count[] = new int[26];
        for (int i1 = 0, i2 = ind; i1 < s1.length(); i1++, i2++) {
            count[s1.charAt(i1) - 'a']++;
            count[s2.charAt(i2) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean permutationinString2(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int i = 0;
        for (; i < l1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (contains(count1, count2)) {
            return true;
        }
        for (; i < l2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - l1) - 'a']--;
            if (contains(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
