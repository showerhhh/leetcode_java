import java.util.ArrayList;

public class t116 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Node> one_level = new ArrayList<Node>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove(0);
                one_level.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            process(one_level);
        }
        return root;
    }

    void process(ArrayList<Node> t) {
        for (int i = 0; i < t.size() - 1; i++) {
            t.get(i).next = t.get(i + 1);
        }
        t.get(t.size() - 1).next = null;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}