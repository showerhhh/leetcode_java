import java.util.List;

public class t559 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        for (Node node : root.children) {
            int tmp = maxDepth(node);
            if (tmp > depth) {
                depth = tmp;
            }
        }
        return depth + 1;
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