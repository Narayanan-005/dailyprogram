import java.util.Scanner;

public class Anagram3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        if (isAnagram(str1, str2)) {
            System.out.println("The Given String is Anagram");
        } else {
            System.out.println("The Given String is Not Anagram");
        }
    }

    public static boolean isAnagram(String str1,String str2){
        if(str2.isEmpty()){
            return str1.isEmpty();
        }else if(str1.isEmpty()){
            return str2.isEmpty();
        }
        int i = str2.indexOf(String.valueOf(str1.charAt(0)));
        if(i == -1){
            return false;
        }
        return isAnagram(str1.substring(1),str2.substring(0,i)+str2.substring(i+1));
    }
}
