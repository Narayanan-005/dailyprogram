class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(convertBinaryNumberinaLinkedListtoInteger1(head));
        System.out.println(convertBinaryNumberinaLinkedListtoInteger2(head));
        System.out.println(convertBinaryNumberinaLinkedListtoInteger3(head));
    }

    private static int convertBinaryNumberinaLinkedListtoInteger1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private static int convertBinaryNumberinaLinkedListtoInteger2(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
    }

    private static int convertBinaryNumberinaLinkedListtoInteger3(ListNode head) {
        head = reverse(head);
        int i = 1;
        int num = 0;
        while (head != null) {
            if (head.val == 1) {
                num += i;
            }
            i *= 2;
            head = head.next;
        }
        return num;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = null;
        while (head != null) {
            curr = head;
            head = head.next;
            curr.next = pre;
            pre = curr;
        }
        return pre;
    }
}
