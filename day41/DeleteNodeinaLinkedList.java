class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNodeinaLinkedList {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node9 = new ListNode(9);
        node4.next = node5;
        node5.next = node1;
        node1.next = node9;
        printResult(node4);
        System.out.println("==================");
        deleteNodeinaLinkedList(node1);
        printResult(node4);
    }

    private static void printResult(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void deleteNodeinaLinkedList(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
