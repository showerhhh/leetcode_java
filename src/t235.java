import java.util.ArrayList;

public class t235 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p_path = getPath(root, p);
        ArrayList<TreeNode> q_path = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < p_path.size() && i < q_path.size(); i++) {
            if (p_path.get(i) == q_path.get(i)) {
                ancestor = p_path.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    ArrayList<TreeNode> getPath(TreeNode root, TreeNode target) {
        // 在二叉搜索树中找到从根节点到目标节点的路径
        ArrayList<TreeNode> path = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            path.add(cur);
            if (target.val < cur.val) {
                cur = cur.left;
            } else if (target.val > cur.val) {
                cur = cur.right;
            } else {
                return path;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
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