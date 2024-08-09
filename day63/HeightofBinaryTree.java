class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }

    Node(int item, Node left, Node right) {
        data = item;
        this.left = left;
        this.right = right;
    }
}

public class HeightofBinaryTree {
    public static void main(String[] args) {
        Node head = new Node(2, null, new Node(1, new Node(3), null));
        System.out.println(heightofBinaryTree1(head));
        System.out.println(heightofBinaryTree2(head));
    }

    static int max = 0;

    private static int heightofBinaryTree1(Node node) {
        max(node, 0);
        return max;
    }

    private static void max(Node node, int n) {
        if (node == null) {
            max = Math.max(max, n);
            return;
        }
        max(node.left, n + 1);
        max(node.right, n + 1);
    }

    private static int heightofBinaryTree2(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightofBinaryTree2(node.left), heightofBinaryTree2(node.right));
    }
}
