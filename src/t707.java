public class t707 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MyLinkedList {
    Node empty;
    int n;

    public MyLinkedList() {
        empty = new Node(-1);
        n = 0;
    }

    public Node _get(int index) {
        if (index < -1 || index >= n) {  // index越界处理
            return null;
        }
        Node p = empty;
        for (int i = -1; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public int get(int index) {
        if (index < 0 || index >= n) {  // index越界处理
            return -1;
        }
        return _get(index).val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(n, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > n) {  // index越界处理
            return;
        } else if (index < 0) {
            index = 0;
        }
        Node p = _get(index - 1);
        Node q = new Node(val);
        q.next = p.next;
        p.next = q;
        n++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) {
            return;
        }
        Node p = _get(index - 1);
        p.next = p.next.next;
        n--;
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */