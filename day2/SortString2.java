public class SortString2 {
    public static void main(String[] args) {
        String str = "Narayanan";
        System.out.println(sortString(str));
    }

    public static String sortString(String str) {
        String arr[] = str.split("");
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < str.length(); i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    String temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
