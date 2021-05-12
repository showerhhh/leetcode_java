import java.util.ArrayList;

public class t872 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        dfs(list1, root1);
        dfs(list2, root2);
        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    void dfs(ArrayList<Integer> list, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        if (node.left != null) {
            dfs(list, node.left);
        }
        if (node.right != null) {
            dfs(list, node.right);
        }

    }

    //    // 深度优先遍历模板
    //    void dfs(Node node) {
    //        if (node已被访问) {
    //            return;
    //        }
    //        访问node;
    //        for (Node neighbor : node的所有邻居节点) {
    //            dfs(neighbor);
    //        }
    //    }
    //
    //    // 回溯模板
    //    void traceback(int t) {
    //        if (满足输出条件) {
    //            输出解;
    //            return;
    //        }
    //        for (int i = 1; i <= 尝试方法数; i++) {
    //            if (满足进一步搜索条件) {
    //                为进一步搜索所需要的状态打上标记;
    //                traceback(t + 1);
    //                恢复到打标记前的状态;  // 也就是说的"回溯一步"
    //            }
    //        }
    //    }

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
