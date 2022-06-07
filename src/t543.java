public class t543 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        int m = depth(root.left) + depth(root.right);
        return threeMax(l, r, m);
    }

    int threeMax(int a, int b, int c) {
        int t = Math.max(a, b);
        return Math.max(t, c);
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.max(l, r) + 1;
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