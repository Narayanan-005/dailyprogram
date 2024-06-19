public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchinRotatedSortedArray1(arr, target));
        System.out.println(searchinRotatedSortedArray2(arr, target));
        System.out.println(searchinRotatedSortedArray3(arr, target));
    }

    private static int searchinRotatedSortedArray1(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int searchinRotatedSortedArray2(int arr[], int target) {
        int breakPoint = findBreakPoint(arr);
        if (breakPoint == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        } else if (target < arr[0]) {
            return binarySearch(arr, target, breakPoint + 1, arr.length - 1);
        }
        return binarySearch(arr, target, 0, breakPoint);
    }

    private static int findBreakPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (start < mid && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            } else if (arr[mid] < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int searchinRotatedSortedArray3(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target > arr[mid] && target <= arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
