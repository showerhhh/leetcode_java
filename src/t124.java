public class t124 {
}

class Solution_t124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 二叉树中的所有路径都可归结为left-root-right类型。
        // 因此，求所有节点的left-root-right型路径的最大和，并保存最大值即可。
        f(root);
        return maxSum;
    }

    int f(TreeNode root) {
        // 返回：在以root为根的树中，以root为起点的路径的最大和。（如果为负，则返回0）
        if (root == null) {
            return 0;
        }
        int l = f(root.left);
        int r = f(root.right);
        maxSum = Math.max(maxSum, root.val + l + r);  // 求left-root-right型路径的最大和。
        return fourMax(root.val, root.val + l, root.val + r, 0);
    }

    int fourMax(int a, int b, int c, int d) {
        int x = Math.max(a, b);
        int y = Math.max(c, d);
        return Math.max(x, y);
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