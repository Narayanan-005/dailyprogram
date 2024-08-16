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

public class MaximumSumPathinBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maximumSumPathinBinaryTree1(head));
        System.out.println(maximumSumPathinBinaryTree2(head));
    }

    static int max1 = 0;

    private static int maximumSumPathinBinaryTree1(TreeNode root) {
        getMaxPath1(root);
        return max1;
    }

    private static int getMaxPath1(TreeNode root) {
        if (root == null)
            return 0;
        int leftTNode = Math.max(0, getMaxPath1(root.left));
        int rightTNode = Math.max(0, getMaxPath1(root.right));
        max1 = Math.max(max1, leftTNode + rightTNode + root.val);
        return root.val + Math.max(leftTNode, rightTNode);
    }

    static int max2 = 0;

    private static int maximumSumPathinBinaryTree2(TreeNode root) {
        getMaxPath2(root);
        return max2;
    }

    private static int getMaxPath2(TreeNode root) {
        if (root == null) return 0;
        int lh = getMaxPath2(root.left);
        int rh = getMaxPath2(root.right);
        max2 = Math.max(max2, lh + rh + root.val);
        int ret = Math.max(root.val, Math.max(lh, rh) + root.val);
        max2 = Math.max(max2, ret);
        return ret;
    }
}
