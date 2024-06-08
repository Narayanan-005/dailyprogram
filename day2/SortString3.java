public class SortString3 {
    public static void main(String[] args) {
        String str = "narayanan";
        System.out.println(sortString(str));
    }

    private static String sortString(String str) {
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                builder.append((""+(char)(97+i)).repeat(arr[i]));
            }
        }
        return builder.toString();
    }
}
