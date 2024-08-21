public class GuessNumberHigherorLower {
    static int num;

    private static int guess(int n) {
        if (n == num) {
            return 0;
        } else if (n > num) {
            return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
        num = 6;
        System.out.println(guessNumberHigherorLower1(10));
        System.out.println(guessNumberHigherorLower2(10));
    }

    private static int guessNumberHigherorLower1(int n) {
        while (true) {
            int t = n + guess(n);
            if (t == n) {
                break;
            }
            n = t;
        }
        return n;
    }

    private static int guessNumberHigherorLower2(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
