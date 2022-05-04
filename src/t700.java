public class t700 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode t = root;
        while (t != null) {
            if (val < t.val) {
                t = t.left;
            } else if (val > t.val) {
                t = t.right;
            } else {
                return t;
            }
        }
        return null;
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