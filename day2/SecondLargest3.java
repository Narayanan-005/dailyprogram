public class SecondLargest3 {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, 12, 34, 0, 4, 56};
        System.out.println("Second Largest Number is : " + secondLargest(arr));
    }

    public static int secondLargest(int arr[]) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (first < arr[i]) {
                second = first;
                first = arr[i];
            } else if (second < arr[i]) {
                second = arr[i];
            }
        }
        return second;
    }
}
