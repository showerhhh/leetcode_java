public class t671 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t671 {
    int secondMinNum = Integer.MAX_VALUE;
    int minNum;
    boolean flag = false;

    public int findSecondMinimumValue(TreeNode root) {
        minNum = root.val;
        f(root);
        if (flag) {
            return secondMinNum;
        } else {
            return -1;
        }
    }

    void f(TreeNode node) {
        if (node == null) {
            return;
        }

        f(node.left);
        if (node.val <= secondMinNum && node.val > minNum) {
            secondMinNum = node.val;
            flag = true;
        }
        f(node.right);
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