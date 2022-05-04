public class t112 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t112 {
    boolean flag;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        flag = false;
        if (root == null) {
            return flag;
        }
        backtracking(targetSum, root, 0);
        return flag;
    }

    void backtracking(int target, TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                flag = true;
            }
            return;
        }
        if (root.left != null) {
            backtracking(target, root.left, sum + root.val);
        }
        if (flag) {
            return;
        }
        if (root.right != null) {
            backtracking(target, root.right, sum + root.val);
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