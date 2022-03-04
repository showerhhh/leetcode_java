public class t111 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return minDep(root);
        }
    }

    int minDep(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDep(root.left), minDep(root.right)) + 1;
        } else if (root.left != null) {
            return minDep(root.left) + 1;
        } else {
            return minDep(root.right) + 1;
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