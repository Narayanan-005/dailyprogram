public class FindPeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement1(arr));
        System.out.println(findPeakElement2(arr));
        System.out.println(findPeakElement3(arr, 0));
    }

    private static int findPeakElement1(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1])
                    return 0;
            } else if (i == arr.length - 1) {
                if (arr[i] > arr[i - 1])
                    return i;
            } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private static int findPeakElement2(int[] arr) {
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid + 1 > arr.length - 1 || arr[mid] > arr[mid + 1]) {
                if (mid - 1 < 0 || arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (mid - 1 < 0 || arr[mid] > arr[mid - 1]) {
                start = mid + 1;
            } else {
                if (arr[mid - 1] > arr[mid + 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return mid;
    }

    private static int findPeakElement3(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr.length - 1;
        } else if (arr[index] > arr[index + 1]) {
            return index;
        }
        return findPeakElement3(arr, index + 1);
    }

}
