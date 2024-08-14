public class HalloweenSale {
    public static void main(String[] args) {
        System.out.println(halloweenSale1(20,3,6,80));
        System.out.println(halloweenSale2(20,3,6,80));
        System.out.println(halloweenSale3(20,3,6,80));
    }

    private static int halloweenSale1(int p, int d, int m, int s) {
        int tot = 0;
        int i = -1;
        while (tot <= s) {
            tot += p;
            if (p > m) {
                p -= d;
                if (p < m) {
                    p = m;
                }
            }
            i++;
        }
        return i;
    }

    private static int halloweenSale2(int p, int d, int m, int s) {
        int result = 0;
        while (s >= p) {
            s -= p;
            p = Math.max(m, p - d);
            result++;
        }
        return result;
    }

    private static int halloweenSale3(int p, int d, int m, int s) {
        int n = 1 + (p - m) / d;
        int total = (p + p - (n - 1) * d) * n / 2;
        if (total <= s) {
            return n + (s - total) / m;
        } else
            return 0;
    }
}
