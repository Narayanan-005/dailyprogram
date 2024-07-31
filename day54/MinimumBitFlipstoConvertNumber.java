public class MinimumBitFlipstoConvertNumber {
    public static void main(String[] args) {
        System.out.println(minimumBitFlipstoConvertNumber1(10, 7));
        System.out.println(minimumBitFlipstoConvertNumber2(10, 7));
        System.out.println(minimumBitFlipstoConvertNumber3(10, 7));
    }

    private static int minimumBitFlipstoConvertNumber1(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int count = 0;
        for (int i = s.length() - 1, j = g.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i < 0) {
                if (g.charAt(j) == '1') {
                    count++;
                }
            } else if (j < 0) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            } else if (s.charAt(i) != g.charAt(j)) {
                count++;
            }
        }
        return count;
    }

    private static int minimumBitFlipstoConvertNumber2(int start, int goal) {
        int s = start ^ goal;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((s >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    private static int minimumBitFlipstoConvertNumber3(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
