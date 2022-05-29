import java.util.ArrayList;

public class t114 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t114 {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode tmp = list.get(i);
            tmp.left = null;
            tmp.right = list.get(i + 1);
        }
        TreeNode last = list.get(list.size() - 1);
        last.left = null;
        last.right = null;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    public void flatten_2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        flatten_2(l);
        flatten_2(r);
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