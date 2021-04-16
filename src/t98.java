import java.util.ArrayList;

public class t98 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t98 {
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        func(root);
        if (tmp.size() <= 1) {
            return true;
        }
        for (int i = 0; i < tmp.size() - 1; i++) {
            if (tmp.get(i) >= tmp.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    void func(TreeNode node) {
        if (node == null) {
            return;
        }
        func(node.left);
        tmp.add(node.val);
        func(node.right);
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