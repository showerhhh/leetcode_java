public class t剑指_Offer_36 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_36 {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        f(root);
        Node p = head;
        while (p.right != null) {
            p = p.right;
        }
        head.left = p;
        p.right = head;
        return head;
    }

    void f(Node root) {
        if (root == null) {
            return;
        }
        Node l = root.left;
        Node r = root.right;
        f(l);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        } else {
            head = root;
        }
        pre = root;
        f(r);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}