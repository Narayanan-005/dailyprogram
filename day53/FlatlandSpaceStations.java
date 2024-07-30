import java.util.Arrays;

public class FlatlandSpaceStations {
    public static void main(String[] args) {
        System.out.println(flatlandSpaceStations1(5, new int[]{0, 4}));
        System.out.println(flatlandSpaceStations2(5, new int[]{0, 4}));
    }

    private static int flatlandSpaceStations1(int n, int[] c) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = n;
            for (int j = 0; j < c.length; j++) {
                temp = Math.min(temp, Math.abs(c[j] - i));
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    private static int flatlandSpaceStations2(int n, int[] c) {
        Arrays.sort(c);
        int distance = 0;
        int l = c.length;
        distance = Math.max(distance, (c[0] - 0));
        distance = Math.max(distance, ((n - 1) - c[l - 1]));
        for (int i = 1; i < l; i++) {
            distance = Math.max(distance, (c[i] - c[i - 1]) / 2);
        }
        return distance;
    }
}
