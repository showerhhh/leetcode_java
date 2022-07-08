import java.util.HashMap;

public class t138 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t138 {
    public Node copyRandomList(Node head) {
        // 复制节点，并保存原节点到复制节点的映射
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        // 建立复制节点的next和random链接
        p = head;
        while (p != null) {
            map.get(p).next = map.getOrDefault(p.next, null);
            map.get(p).random = map.getOrDefault(p.random, null);
            p = p.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}