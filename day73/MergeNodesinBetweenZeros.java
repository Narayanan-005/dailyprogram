import java.util.ArrayList;
import java.util.List;

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

public class MergeNodesinBetweenZeros {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        ListNode head2 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        printResult(mergeNodesinBetweenZeros1(head1));
        printResult(mergeNodesinBetweenZeros2(head2));
    }

    private static void printResult(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode mergeNodesinBetweenZeros1(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode temp = head.next;
        int val = 0;
        while (temp != null) {
            if (temp.val == 0) {
                list.add(val);
                val = 0;
            } else {
                val += temp.val;
            }
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < list.size(); i++) {
            temp = temp.next;
            temp.val = list.get(i);
        }
        temp.next = null;
        return head.next;
    }

    private static ListNode mergeNodesinBetweenZeros2(ListNode head) {
        ListNode res = new ListNode();
        ListNode pre = res;
        head = head.next;
        int val = 0;
        while (head != null) {
            if (head.val == 0) {
                head.val = val;
                res.next = head;
                res = res.next;
                val = 0;
            } else if (head.val != 0) {
                val += head.val;
            }
            head = head.next;
        }
        return pre.next;
    }
}
