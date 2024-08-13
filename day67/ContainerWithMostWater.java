public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater1(arr));
        System.out.println(containerWithMostWater2(arr));
        System.out.println(containerWithMostWater3(arr));
    }

    private static int containerWithMostWater1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * (Math.min(height[i], height[j])));
            }
        }
        return max;
    }

    private static int containerWithMostWater2(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, (end - start) * (Math.min(height[start], height[end])));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    private static int containerWithMostWater3(int[] height) {
        int start = 0;
        int n = height.length;
        int end = n - 1;
        int highest_area = 0;
        while (start < end) {
            int min = Math.min(height[start], height[end]);
            int area = (end - start) * min;
            if (area > highest_area) highest_area = area;

            while (start < end && height[start] <= min) start++;
            while (start < end && height[end] <= min) end--;
        }

        return highest_area;
    }
}
