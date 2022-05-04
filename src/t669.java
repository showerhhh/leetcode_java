public class t669 {
    public static void main(String[] args) {
        Solution_t669 solution = new Solution_t669();
        solution.test();
    }
}

class Solution_t669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val == high) {
            root.left = trimBST(root.left, low, high);
            root.right = null;
            return root;
        }
        if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root;
        }
        if (root.val > low && root.val < high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
        return null;
    }

    public TreeNode trimBST_v2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST_v2(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST_v2(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBST_v2(root.left, low, high);
            root.right = trimBST_v2(root.right, low, high);
            return root;
        }
        return null;
    }

    void test() {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(2);
        root.left = a;
        root.right = b;
        trimBST(root, 1, 2);
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