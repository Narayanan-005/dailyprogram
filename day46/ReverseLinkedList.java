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

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printResult(reverseLinkedList1(head1));
        printResult(reverseLinkedList2(head2));
    }

    private static void printResult(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode reverseLinkedList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return head;
        }
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int l = list.size();
        for (int i = l - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(l - 1);
    }

    private static ListNode reverseLinkedList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = null;
        while (head != null) {
            curr = head;
            head = head.next;
            curr.next = pre;
            pre = curr;
        }
        return curr;
    }
}
