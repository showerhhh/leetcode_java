public class t404 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t404 {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if (root == null) {
            return 0;
        }
        leftSum(root);
        return sum;
    }

    void leftSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;

            }
            leftSum(root.left);
        }
        if (root.right != null) {
            leftSum(root.right);
        }
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