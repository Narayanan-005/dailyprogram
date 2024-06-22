import java.util.Arrays;

public class AlternateSorting {
    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 2, 3, 6, 7};
        System.out.println(Arrays.toString(alternateSorting1(arr.clone())));
        System.out.println(Arrays.toString(alternateSorting2(arr.clone())));
        System.out.println(Arrays.toString(alternateSorting3(arr.clone())));
    }

    private static int[] alternateSorting1(int arr[]) {
        int l = arr.length;
        int res[] = new int[l];
        Arrays.sort(arr);
        int temp = 0;
        for (int i = 0; i < l; i += 2) {
            res[i] = arr[l - 1 - temp++];
        }
        temp = 0;
        for (int i = 1; i < l; i += 2) {
            res[i] = arr[temp++];
        }
        return res;
    }

    private static int[] alternateSorting2(int arr[]) {
        int res[] = new int[arr.length];
        Arrays.sort(arr);
        int j = 0, k = arr.length - 1;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = arr[k--];
            } else {
                res[i] = arr[j++];
            }
        }
        return res;
    }

    private static int[] alternateSorting3(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = n / 2;
        int[] desc = new int[mid];
        for (int i = 0; i < mid; i++) {
            desc[i] = arr[n - 1 - i];
        }
        int[] asc = Arrays.copyOfRange(arr, 0, mid);
        int[] res = new int[n];
        int ind = 0;
        for (int i = 0; i < mid; i++) {
            res[ind++] = desc[i];
            res[ind++] = asc[i];
        }
        if (n % 2 != 0) {
            res[ind] = arr[mid];
        }
        return res;
    }


}
