public class t701 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.right;
                }
            } else if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.left;
                }
            } else {
                return root;
            }
        }
        return root;
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