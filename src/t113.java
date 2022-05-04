import java.util.ArrayList;
import java.util.List;

public class t113 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t113 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtracking(targetSum, root, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int target, TreeNode root, int sum, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            list.add(root.val);
            backtracking(target, root.left, sum + root.val, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            backtracking(target, root.right, sum + root.val, list);
            list.remove(list.size() - 1);
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