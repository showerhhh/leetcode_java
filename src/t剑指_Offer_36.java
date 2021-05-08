public class t剑指_Offer_36 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_36 {
    public Node treeToDoublyList(Node root) {
        //将以root为根节点的二叉搜索树转换为排序的双循环链表，返回该链表的第一个节点（的指针）
        if (root == null) {
            return null;
        }

        //分
        Node l = treeToDoublyList(root.left);
        Node r = treeToDoublyList(root.right);

        //治
        if (l == null && r == null) {
            root.left = root;  // 构建自环
            root.right = root;  // 构建自环

            return root;
        } else if (l != null && r != null) {
            Node l_tail = l.left;
            l_tail.right = root;  // 连接左侧
            root.left = l_tail;  // 连接左侧

            Node r_tail = r.left;
            r.left = root;  // 连接右侧
            root.right = r;  // 连接右侧

            l.left = r_tail;  // 构成循环
            r_tail.right = l;  // 构成循环

            return l;
        } else if (l == null) {
            Node r_tail = r.left;
            r.left = root;  // 连接右侧
            root.right = r;  // 连接右侧

            root.left = r_tail;
            r_tail.right = root;

            return root;
        } else {
            Node l_tail = l.left;
            l_tail.right = root;  // 连接左侧
            root.left = l_tail;  // 连接左侧

            root.right = l;
            l.left = root;

            return l;
        }
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