import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class t863 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t863 {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeParentMap(root);
        dfs(target, 0, k);
        return res;
    }

    void makeParentMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left.val, root);
            makeParentMap(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            makeParentMap(root.right);
        }
    }

    void dfs(TreeNode node, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            res.add(node.val);
            return;
        }
        visited.add(node.val);
        if (node.left != null && !visited.contains(node.left.val)) {
            dfs(node.left, depth + 1, k);
        }
        if (node.right != null && !visited.contains(node.right.val)) {
            dfs(node.right, depth + 1, k);
        }
        TreeNode parent = map.getOrDefault(node.val, null);
        if (parent != null && !visited.contains(parent.val)) {
            dfs(parent, depth + 1, k);
        }
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