import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twonumberswithoddoccurrences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twonumberswithoddoccurrences1(new int[]{4, 2, 4, 5, 2, 3, 3, 1}, 8)));
        System.out.println(Arrays.toString(twonumberswithoddoccurrences2(new int[]{4, 2, 4, 5, 2, 3, 3, 1}, 8)));
        System.out.println(Arrays.toString(twonumberswithoddoccurrences3(new int[]{4, 2, 4, 5, 2, 3, 3, 1}, 8)));
    }

    private static int[] twonumberswithoddoccurrences1(int[] Arr, int N) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            map.put(Arr[i], map.getOrDefault(Arr[i], 0) + 1);
        }
        int[] res = new int[2];
        int j = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                res[j--] = entry.getKey();
            }
        }
        if (res[0] < res[1]) {
            res[0] += res[1];
            res[1] = res[0] - res[1];
            res[0] = res[0] - res[1];
        }
        return res;
    }

    private static int[] twonumberswithoddoccurrences2(int[] Arr, int N) {
        Arrays.sort(Arr);
        int res[] = new int[2];
        int j = 1;
        int count = 1;
        int i = 1;
        for (; i < N; i++) {
            if (Arr[i] == Arr[i - 1]) {
                count++;
            } else {
                if (count % 2 == 1) {
                    res[j--] = Arr[i - 1];
                }
                count = 1;
            }
        }
        if (count % 2 == 1) {
            res[j--] = Arr[i - 1];
        }
        return res;
    }

    private static int[] twonumberswithoddoccurrences3(int[] Arr, int N) {
        int xor = Arr[0];
        for (int i = 1; i < N; i++) {
            xor ^= Arr[i];
        }
        int bit = (xor & (~(xor - 1)));
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            if ((Arr[i] & bit) == 0) {
                x ^= Arr[i];
            } else {
                y ^= Arr[i];
            }
        }
        return new int[]{Math.max(x, y), Math.min(x, y)};
    }
}
