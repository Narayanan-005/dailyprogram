import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(assignCookies1(g, s));
        System.out.println(assignCookies2(g, s));
    }

    private static int assignCookies1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    private static int assignCookies2(int[] g, int[] s) {
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < g.length; i++) {
            if (max1 < g[i]) {
                max1 = g[i];
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (max2 < s[i]) {
                max2 = s[i];
            }
        }
        int arr1[] = new int[max1 + 1];
        int arr2[] = new int[max2 + 1];
        for (int i = 0; i < g.length; i++) {
            arr1[g[i]]++;
        }
        for (int i = 0; i < s.length; i++) {
            arr2[s[i]]++;
        }
        int count = 0, i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            while (i < arr1.length && arr1[i] == 0) {
                i++;
                j = i;
            }
            while (j < arr2.length && arr2[j] == 0) {
                j++;
            }
            if (i < arr1.length && j < arr2.length && j >= i) {
                count++;
                arr1[i]--;
                arr2[j]--;
            }
        }
        return count;
    }

}
