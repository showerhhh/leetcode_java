import java.util.Arrays;

public class t654 {
    public static void main(String[] args) {
        Solution_t654 solution = new Solution_t654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        solution.constructMaximumBinaryTree(nums);
    }
}

class Solution_t654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        int index = searchMax(nums);
        int[] left = Arrays.copyOfRange(nums, 0, index);
        int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

    int searchMax(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
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