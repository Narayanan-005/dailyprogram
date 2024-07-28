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

public class DeletetheMiddleNodeofaLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        printResult(deletetheMiddleNodeofaLinkedList1(head1));
        printResult(deletetheMiddleNodeofaLinkedList2(head2));
        printResult(deletetheMiddleNodeofaLinkedList3(head3));
    }

    private static void printResult(ListNode listNode) {
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode deletetheMiddleNodeofaLinkedList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() < 2) {
            return null;
        }
        ListNode node = list.get((list.size() / 2) - 1);
        node.next = node.next.next;
        return list.get(0);
    }

    private static ListNode deletetheMiddleNodeofaLinkedList2(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        if (l < 2) {
            return null;
        }
        l /= 2;
        temp = head;
        for (int i = 1; i < l; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    private static ListNode deletetheMiddleNodeofaLinkedList3(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode pre = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
