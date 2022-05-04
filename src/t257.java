import java.util.ArrayList;
import java.util.List;

public class t257 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t257 {
    ArrayList<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        backtracking(root, "");
        return res;
    }

    void backtracking(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            String t = s + "->" + String.valueOf(root.val);
            t = t.substring(2);
            res.add(t);
            return;
        }
        if (root.left != null) {
            backtracking(root.left, s + "->" + String.valueOf(root.val));
        }
        if (root.right != null) {
            backtracking(root.right, s + "->" + String.valueOf(root.val));
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