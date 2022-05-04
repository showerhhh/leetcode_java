import java.util.Arrays;

public class t108 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = n / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, n));
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