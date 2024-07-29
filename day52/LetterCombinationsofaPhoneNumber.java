import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinationsofaPhoneNumber1("23"));
        System.out.println(letterCombinationsofaPhoneNumber2("23"));
    }

    private static List<String> letterCombinationsofaPhoneNumber1(String digits) {
        List<String> words = Arrays.asList("", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList();
        if (digits.length() > 0) {
            result = Arrays.asList(words.get(digits.charAt(0) - '1').split(""));
        }
        for (int i = 1; i < digits.length(); i++) {
            String[] arr = words.get(digits.charAt(i) - '1').split("");
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < arr.length; k++) {
                    temp.add(result.get(j) + arr[k]);
                }
            }

            result = temp;
            temp = new ArrayList();
        }
        return result;
    }

    private static List<String> letterCombinationsofaPhoneNumber2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String> words = Arrays.asList("", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        letterCombinationRec(digits, 0, new StringBuilder(), res, words);
        return res;
    }

    private static void letterCombinationRec(String digits, int idx, StringBuilder comb, List<String> res, List<String> words) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters = words.get(digits.charAt(idx) - '1');
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            letterCombinationRec(digits, idx + 1, comb, res, words);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}

