public class t337 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t337 {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    int[] robTree(TreeNode root) {
        // 返回两个数，第一个数表示选择该节点所能获得的最大和，第二个数表示不选择该节点所能获得的最大和。
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
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