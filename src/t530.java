public class t530 {
}

class Solution_t530 {
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        f(root);
        return minDiff;
    }

    void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.left);
        if (pre != null && root.val - pre.val < minDiff) {
            minDiff = root.val - pre.val;
        }
        pre = root;
        f(root.right);
    }

    public class TreeNode {
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
}