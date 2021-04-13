import java.util.ArrayList;

public class t783 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class TreeNode {
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

class Solution_t783 {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int minDiffInBST(TreeNode root) {
        func(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    void func(TreeNode t) {
        if (t == null) {
            return;
        }
        func(t.left);
        list.add(t.val);
        func(t.right);
    }
}