import java.util.HashMap;

public class t面试题_1625 {
    public static void main(String[] args) {
        LRUCache_t面试题_1625 cache = new LRUCache_t面试题_1625(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}

class LRUCache_t面试题_1625 {
    int size;
    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache_t面试题_1625(int capacity) {
        size = 0;
        cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node p = map.get(key);
        removeNodeToLast(p);
        return p.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            map.put(key, p);
            removeNodeToLast(p);
            return;
        }
        Node p = new Node(key, value);
        map.put(key, p);
        putNodeToLast(p);
        size++;
        if (size > cap) {
            Node q = removeFirst();
            map.remove(q.key, q);
            size--;
        }
    }

    void removeNodeToLast(Node p) {
        // 将链表中节点p移动到末尾
        if (p == tail) {
            return;
        }
        // 取出
        p.pre.nex = p.nex;
        p.nex.pre = p.pre;
        // 放回
        p.pre = tail;
        tail.nex = p;
        p.nex = null;
        tail = p;
    }

    void putNodeToLast(Node p) {
        // 将新节点p插入到末尾
        p.pre = tail;
        tail.nex = p;
        p.nex = null;
        tail = p;
    }

    Node removeFirst() {
        // 将首位节点移除，并返回
        Node p = head.nex;
        if (p == tail) {
            head.nex = null;
            tail = head;
            return p;
        }
        p.pre.nex = p.nex;
        p.nex.pre = p.pre;
        return p;
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node nex;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            nex = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */