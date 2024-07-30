import java.util.ArrayList;
import java.util.List;

public class FindtheCountofNumbersWhichAreNotSpecial {
    public static void main(String[] args) {
        System.out.println(findtheCountofNumbersWhichAreNotSpecial1(5, 7));
        System.out.println(findtheCountofNumbersWhichAreNotSpecial2(5, 7));
        System.out.println(findtheCountofNumbersWhichAreNotSpecial3(5, 7));
    }

    private static int findtheCountofNumbersWhichAreNotSpecial1(int l, int r) {
        int count = 0;
        while (l <= r) {
            if (!isSpecial(l)) {
                count++;
            }
            l++;
        }
        return count;
    }

    private static boolean isSpecial(int n) {
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return count == 2;
    }

    private static int findtheCountofNumbersWhichAreNotSpecial2(int l, int r) {
        List<Integer> primes = getPrimes((int) Math.sqrt(r));
        int count = r - l + 1;
        for (int i = 0; i < primes.size(); i++) {
            int t = primes.get(i) * primes.get(i);
            if (t >= l && t <= r) {
                count--;
            }
        }
        return count;
    }

    private static List<Integer> getPrimes(int n) {
        boolean arr[] = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2 * i; j <= n; j += i) {
                arr[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }
        return list;
    }

    private static int findtheCountofNumbersWhichAreNotSpecial3(int l, int r) {
        int[] arr = getPrimes((int) Math.sqrt(l - 1), (int) Math.sqrt(r));
        return r - l + 1 - (arr[1] - arr[0]);
    }

    private static int[] getPrimes(int l, int h) {
        boolean arr[] = new boolean[h + 1];
        for (int i = 2; i <= Math.sqrt(h); i++) {
            for (int j = i + i; j <= h; j += i) {
                arr[j] = true;
            }
        }
        int res[] = new int[2];
        int count = 0;
        for (int i = 2; i <= h; i++) {
            if (!arr[i]) {
                count++;
            }
            if (i == l) {
                res[0] = count;
            }
        }
        res[1] = count;
        return res;
    }

}
