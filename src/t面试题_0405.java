public class t面试题_0405 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0405 {
    public boolean isValidBST(TreeNode root) {
        return func(root, null, null);
    }

    boolean func(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        boolean flag1 = true;
        if (low != null && root.val <= low) {
            flag1 = false;
        }
        if (high != null && root.val >= high) {
            flag1 = false;
        }
        boolean flag2 = func(root.left, low, root.val);
        boolean flag3 = func(root.right, root.val, high);
        return flag1 && flag2 && flag3;
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