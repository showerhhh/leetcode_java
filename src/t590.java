import java.util.ArrayList;
import java.util.List;

public class t590 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t590 {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    void f(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            f(node, res);
        }
        res.add(root.val);
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