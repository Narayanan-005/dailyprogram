import java.util.Arrays;

public class SortString1 {
    public static void main(String[] args) {
        String str = "narayanan";
        System.out.println(sortString(str));
    }

    public static String sortString(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
