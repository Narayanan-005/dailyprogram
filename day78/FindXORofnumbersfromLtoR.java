public class FindXORofnumbersfromLtoR {
    public static void main(String[] args) {
        System.out.println(findXORofnumbersfromLtoR1(4, 8));
        System.out.println(findXORofnumbersfromLtoR2(4, 8));
    }

    private static int findXORofnumbersfromLtoR1(int l, int r) {
        int res = l++;
        for (; l <= r; l++) {
            res ^= l;
        }
        return res;
    }

    private static int findXORofnumbersfromLtoR2(int l, int r) {
        return (findXor(l - 1) ^ findXor(r));
    }

    private static int findXor(int n) {
        int mod = n % 4;
        if (mod == 0)
            return n;
        else if (mod == 1)
            return 1;
        else if (mod == 2)
            return n + 1;
        else if (mod == 3)
            return 0;
        return 0;
    }

}
