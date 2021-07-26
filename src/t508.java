import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t508 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();  // key为子树元素和，value为出现次数
        tree_sum(root, map);
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v > maxCount) {
                maxCount = v;
            }
        }
        ArrayList<Integer> res_list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v == maxCount) {
                res_list.add(k);
            }
        }
        int[] res = new int[res_list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = res_list.get(i);
        }
        return res;
    }

    int tree_sum(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = tree_sum(root.left, map);
        int right = tree_sum(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
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