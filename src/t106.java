import java.util.Arrays;

public class t106 {
    public static void main(String[] args) {
        Solution_t106 solution = new Solution_t106();
        int[] inoder = new int[]{9, 3, 15, 20, 7};
        int[] postoder = new int[]{9, 15, 7, 20, 3};
        solution.buildTree(inoder, postoder);
    }
}

class Solution_t106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new TreeNode(postorder[n - 1]);
        }
        int val = postorder[n - 1];
        int idx = search(inorder, val);
        TreeNode root = new TreeNode(val);
        int[] left_inorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] left_postorder = Arrays.copyOfRange(postorder, 0, idx);
        root.left = buildTree(left_inorder, left_postorder);
        int[] right_inorder = Arrays.copyOfRange(inorder, idx + 1, n);
        int[] right_postorder = Arrays.copyOfRange(postorder, idx, n - 1);
        root.right = buildTree(right_inorder, right_postorder);
        return root;
    }

    int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
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