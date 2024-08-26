public class BeautifulTowersI {
    public static void main(String[] args) {
        System.out.println(beautifulTowersI1(new int[]{5, 3, 4, 1, 1}));
    }

    public static long beautifulTowersI1(int[] heights) {
        long res = 0;
        for (int i = 0; i < heights.length; i++) {
            long count = heights[i];
            int val = heights[i];
            int j = i - 1;
            while (j >= 0) {
                count += (val = Math.min(heights[j--], val));
            }
            j = i + 1;
            val = heights[i];
            while (j < heights.length) {
                count += (val = Math.min(heights[j++], val));
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
