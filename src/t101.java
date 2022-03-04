public class t101 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return twoTreeIsSym(root.left, root.right);
    }

    boolean twoTreeIsSym(TreeNode root1, TreeNode root2) {
        // 判断两树是否对称
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            return root1.val == root2.val && twoTreeIsSym(root1.left, root2.right) && twoTreeIsSym(root1.right, root2.left);
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