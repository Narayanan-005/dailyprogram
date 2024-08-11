import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignerPDFViewer {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
        System.out.println(designerPDFViewer1(list, "zaba"));
        System.out.println(designerPDFViewer2(list, "zaba"));
        System.out.println(designerPDFViewer3(list, "zaba", 0));
    }

    private static int designerPDFViewer1(List<Integer> h, String word) {
        Map<Character, Integer> map = new HashMap();
        for (char ch : word.toCharArray()) {
            map.put(ch, h.get(ch - 'a'));
        }
        int height = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            height = Math.max(height, entry.getValue());
        }
        return word.length() * height;
    }

    private static int designerPDFViewer2(List<Integer> h, String word) {
        int height = 1;
        for (int i = 0; i < word.length(); i++) {
            height = Math.max(height, h.get(word.charAt(i) - 'a'));
        }
        return word.length() * height;
    }

    static int height = 0;

    private static int designerPDFViewer3(List<Integer> h, String word, int index) {
        if (index == word.length()) {
            return 0;
        }
        height = Math.max(height, h.get(word.charAt(index) - 'a'));
        return height + designerPDFViewer3(h, word, index + 1);
    }
}
