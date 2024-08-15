class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterofBinaryTree1(root));
        System.out.println(diameterofBinaryTree2(root));
    }

    static int r = 0;

    private static int diameterofBinaryTree1(TreeNode root) {
        rec(root);
        return r;
    }

    private static int rec(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = 1 + rec(root.left);
        int right = 1 + rec(root.right);
        if (left + right > r) {
            r = left + right;
        }
        return Math.max(left, right);
    }

    private static int diameterofBinaryTree2(TreeNode root) {
        return dai(root);
    }

    private static int dai(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = dai(root.left);
        int rd = dai(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh + rh, Math.max(ld, rd));
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
}
