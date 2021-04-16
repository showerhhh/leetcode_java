import java.util.ArrayList;
import java.util.List;

public class t429 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t429 {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> one_level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove(0);
                one_level.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                }
            }
            result.add(one_level);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}