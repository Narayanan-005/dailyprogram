import java.util.LinkedList;
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

public class RotateList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printResult(rotateList1(head1, 2));
        printResult(rotateList1(head2, 2));
    }

    private static void printResult(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode rotateList1(ListNode head, int k) {
        List<ListNode> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if (list.size() > 0) {
            k %= list.size();
        }
        if (k == 0 || list.size() < 2) {
            return head;
        }
        list.get(list.size() - k - 1).next = null;
        list.get(list.size() - 1).next = list.get(0);
        return list.get(list.size() - k);
    }

    private static ListNode rotateList2(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            if (k-- > 0) {
                fast = fast.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }
}
