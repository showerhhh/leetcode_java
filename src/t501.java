import java.util.ArrayList;

public class t501 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t501 {
    TreeNode pre = null;
    int maxCount = 1;
    int count = 1;
    ArrayList<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        f(root);
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.left);
        if (pre != null) {
            if (root.val == pre.val) {
                count++;
            } else {
                count = 1;
            }
        }
        pre = root;

        if (count == maxCount) {
            res.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        f(root.right);
    }

    ArrayList<Integer> findMode(int[] nums) {
        // 求有序数组中的众数
        int count = 1;
        int maxCount = 1;
        ArrayList<Integer> res = new ArrayList<>(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == maxCount) {
                res.add(nums[i]);  // 处理众数可能有多个的情况。
            } else if (count > maxCount) {
                maxCount = count;
                // 当频率最大值更新时，清空res，并将当前值放入。
                res.clear();
                res.add(nums[i]);
            }
        }
        return res;
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