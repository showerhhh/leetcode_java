import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t剑指_Offer_32_III {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        boolean flag = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                level.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(reverse(level, flag));
            flag = !flag;
        }
        return res;
    }

    ArrayList<Integer> reverse(ArrayList<Integer> list, boolean flag) {
        if (!flag) {
            return list;
        }
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            int t = list.get(i);
            list.set(i, list.get(n - 1 - i));
            list.set(n - 1 - i, t);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}