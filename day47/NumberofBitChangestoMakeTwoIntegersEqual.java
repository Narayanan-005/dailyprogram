public class NumberofBitChangestoMakeTwoIntegersEqual {
    public static void main(String[] args) {
        System.out.println(numberofBitChangestoMakeTwoIntegersEqual1(5, 4));
        System.out.println(numberofBitChangestoMakeTwoIntegersEqual2(5, 4));
        System.out.println(numberofBitChangestoMakeTwoIntegersEqual3(5, 4));
    }

    private static int numberofBitChangestoMakeTwoIntegersEqual1(int n, int k) {
        if (n == k) {
            return 0;
        } else if (n < k) {
            return -1;
        }
        int count = 0;
        char[] ns = Integer.toBinaryString(n).toCharArray();
        char[] ks = Integer.toBinaryString(k).toCharArray();
        for (int i = ns.length - 1, j = ks.length - 1; i >= 0; i--, j--) {
            if (j < 0) {
                if (ns[i] == '1') {
                    count++;
                }
            } else if (ks[j] != ns[i] && ns[i] == '1') {
                count++;
            } else if (ks[j] != ns[i]) {
                return -1;
            }
        }
        return count;
    }

    private static int numberofBitChangestoMakeTwoIntegersEqual2(int n, int k) {
        if (n == k) {
            return 0;
        } else if (n < k) {
            return -1;
        }
        int count = 0;
        char[] ns = binaryString(n).toCharArray();
        char[] ks = binaryString(k).toCharArray();
        for (int i = ns.length - 1, j = ks.length - 1; i >= 0; i--, j--) {
            if (j < 0) {
                if (ns[i] == '1') {
                    count++;
                }
            } else if (ks[j] != ns[i] && ns[i] == '1') {
                count++;
            } else if (ks[j] != ns[i]) {
                return -1;
            }
        }
        return count;
    }

    private static String binaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }

    private static int numberofBitChangestoMakeTwoIntegersEqual3(int n, int k) {
        int count = 0;
        while (n > 0 || k > 0) {
            if ((k & 1) == 1) {
                if ((n & 1) != 1) {
                    return -1;
                }
            } else {
                if ((n & 1) == 1) {
                    count++;
                }
            }
            n = n >> 1;
            k = k >> 1;
        }
        return count;
    }
}
