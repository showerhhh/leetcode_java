import java.util.ArrayList;
import java.util.List;

public class t剑指_Offer_34 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_34 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        backtracking(root, target, 0, new ArrayList<>());
        return res;
    }

    void backtracking(TreeNode root, int target, int sum, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            sum += root.val;
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        sum += root.val;
        if (root.left != null) {
            backtracking(root.left, target, sum, list);
        }
        if (root.right != null) {
            backtracking(root.right, target, sum, list);
        }
        sum -= root.val;
        list.remove(list.size() - 1);
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