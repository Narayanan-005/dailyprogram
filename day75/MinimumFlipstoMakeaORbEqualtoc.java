public class MinimumFlipstoMakeaORbEqualtoc {
    public static void main(String[] args) {
        System.out.println(minimumFlipstoMakeaORbEqualtoc1(2, 6, 5));
        System.out.println(minimumFlipstoMakeaORbEqualtoc2(2, 6, 5));
    }

    private static int minimumFlipstoMakeaORbEqualtoc1(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int ta = a >> i & 1;
            int tb = b >> i & 1;
            int tc = c >> i & 1;
            if (tc == 0) {
                count += ta + tb;
            } else if (tc == 1 && ta != 1 && tb != 1) {
                count++;
            }
        }
        return count;
    }

    private static int minimumFlipstoMakeaORbEqualtoc2(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }
        int val = 0;
        if ((c & 1) == 0) {
            val = (a & 1) + (b & 1);
        } else if ((a & 1) == 0 && (b & 1) == 0) {
            val = 1;
        }
        return val + minimumFlipstoMakeaORbEqualtoc2(a >> 1, b >> 1, c >> 1);
    }
}
