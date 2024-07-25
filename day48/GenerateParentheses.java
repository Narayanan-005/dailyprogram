import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(generateParentheses(scanner.nextInt()));
    }

    private static List<String> generateParentheses(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> li = new ArrayList<>();
        li.add("");
        list.add(li);

        for (int i = 1; i <= n; i++) {
            List<String> currList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String first : list.get(j)) {
                    for (String second : list.get(i - 1 - j)) {
                        currList.add("(" + first + ")" + second);
                    }
                }
            }
            list.add(currList);
        }

        return list.get(n);
    }
}
