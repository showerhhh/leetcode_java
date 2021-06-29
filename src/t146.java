import java.util.HashMap;

public class t146 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int size = 0;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node != null) {
            // 关键字存在，返回其值，并将其放到双向链表的末尾。
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            return node.value;
        } else {
            // 关键字不存在，返回-1。
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node != null) {
            // 关键字存在，更新其值，将其放到双向链表的末尾。
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;

            node.value = value;
            return;
        } else {
            // 关键字不存在，创建新的Node，将其放入双向链表的末尾，更新map和size。
            Node new_node = new Node(key, value);
            new_node.prev = tail.prev;
            new_node.next = tail;
            tail.prev.next = new_node;
            tail.prev = new_node;

            map.put(key, new_node);
            size++;

            // 若size超出capacity，则去掉双向链表的头部，更新map和size。
            if (size > capacity) {
                Node remove_node = head.next;
                remove_node.prev.next = remove_node.next;
                remove_node.next.prev = remove_node.prev;
                remove_node.prev = null;
                remove_node.next = null;

                map.remove(remove_node.key);
                size--;
            }
            return;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */