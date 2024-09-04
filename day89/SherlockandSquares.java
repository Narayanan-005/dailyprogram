public interface SherlockandSquares {
    public static void main(String[] args) {
        System.out.println(sherlockandSquares1(25, 49));
        System.out.println(sherlockandSquares2(25, 49));
    }

    private static int sherlockandSquares1(int a, int b) {
        int count = 0;
        for (int i = 1; i * i <= b; i++) {
            if (i * i >= a) {
                count++;
            }
        }
        return count;
    }

    private static int sherlockandSquares2(int a, int b) {
        int val = (int) Math.sqrt(a);
        int res = (int) Math.sqrt(b) - val;
        if (val * val == a) {
            res++;
        }
        return res;
    }
}
