public class UglyNumberIII {
    public static void main(String[] args) {
        System.out.println(uglyNumberIII1(3, 2, 3, 5));
        System.out.println(uglyNumberIII2(3, 2, 3, 5));
    }

    private static int uglyNumberIII1(int n, int a, int b, int c) {
        long x = 1, y = 1, z = 1;
        int lucky = 0;
        while (n-- > 0) {
            long v1 = x * a, v2 = y * b, v3 = z * c;
            if (v1 < v2 && v1 < v3) {
                lucky = (int) v1;
                if (v1 == v2) y++;
                if (v1 == v3) z++;
                x++;
            } else if (v2 < v3) {
                lucky = (int) v2;
                if (v1 == v2) x++;
                if (v2 == v3) z++;
                y++;
            } else {
                lucky = (int) v3;
                if (v3 == v2) y++;
                if (v1 == v3) x++;
                z++;
            }
        }
        return lucky;
    }

    private static int uglyNumberIII2(int n, int a, int b, int c) {
        int lo = 1, hi = (int) 2e9;
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long count = 0L + mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
