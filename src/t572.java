public class t572 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    boolean isSame(TreeNode root1, TreeNode root2) {
        // 判断两树是否相同
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
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