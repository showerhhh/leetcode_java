public class t面试题_0410 {
}

class Solution_t面试题_0410 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null) {
            return sameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        } else {
            return false;
        }
    }

    boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null) {
            return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}