public class MissingNumber2 {
    public static void main(String[] args) {
        int arr[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int arr[]) {
        boolean temp[] = new boolean[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!temp[i]) {
                return i;
            }
        }
        return 0;
    }
}
