import java.util.ArrayList;

public class t897 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t897 {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();

    public TreeNode increasingBST(TreeNode root) {
        func(root);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            if (i == list.size() - 1) {
                list.get(i).right = null;
            } else {
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    void func(TreeNode node) {
        if (node == null) {
            return;
        }
        func(node.left);
        list.add(node);
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