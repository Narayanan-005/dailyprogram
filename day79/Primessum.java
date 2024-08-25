import java.util.HashSet;
import java.util.Set;

public class Primessum {
    public static void main(String[] args) {
        System.out.println(primessum1(34));
        System.out.println(primessum2(34));
        System.out.println(primessum3(34));
    }

    private static String primessum1(int N) {
        for (int i = 1; i <= N / 2; i++) {
            if (isPrime(i) && isPrime(N - i)) {
                return "Yes";
            }
        }
        return "No";
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static String primessum2(int N) {
        Set<Integer> primes = getPrimes(N);
        for (Integer i : primes) {
            if (primes.contains(N - i)) {
                return "Yes";
            }
        }
        return "No";
    }

    private static Set<Integer> getPrimes(int n) {
        boolean arr[] = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i + i; j <= n; j += i) {
                arr[j] = true;
            }
        }
        Set<Integer> set = new HashSet();
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                set.add(i);
            }
        }
        return set;
    }

    private static String primessum3(int N) {
        if (isPossible(N)) return "Yes";
        else return "No";
    }

    static boolean isPossible(int N) {
        if (N < 4)
            return false;
        if (N % 2 == 0)
            return true;
        return isPrime(N - 2);
    }
}
