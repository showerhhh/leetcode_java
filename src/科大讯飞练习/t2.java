package 科大讯飞练习;

import java.util.Arrays;
import java.util.Comparator;

public class t2 {
    public static void main(String[] args) {
        t2 t = new t2();
        Node[] nodes = new Node[]{
                new Node(0, 0), new Node(0, 3), new Node(1, 2), new Node(3, 4), new Node(5, 6),
                new Node(7, 8), new Node(1, 4), new Node(2, 4), new Node(3, 5), new Node(5, 0),
                new Node(5, 5), new Node(2, 0), new Node(2, 2), new Node(3, 0), new Node(3, 3),
                new Node(4, 5), new Node(6, 1), new Node(3, 7), new Node(4, 0), new Node(5, 2),
        };
        System.out.println(t.f(nodes));
    }

    boolean equ(double x, double y)//实数判断是否相等
    {
        if (x > y || y > x) {
            return false;
        } else {
            return true;
        }
    }

    int f(Node[] nodes) {
        int ans = 0;
        for (Node zero : nodes) {
            for (int i = 0; i < nodes.length; i++) {
                nodes[i].move(zero.x, zero.y);
                nodes[i].save_area();
                while (!nodes[i].isArea1()) {
                    nodes[i].turn();
                }
                nodes[i].cal_k();
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.k < o2.k) {
                        return -1;
                    } else if (o1.k > o2.k) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            int i = 0;
            while (i < nodes.length) {
                int j = i;
                while (j < nodes.length && equ(nodes[j].k, nodes[i].k)) {
                    j++;
                }
                int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
                for (int p = i; p < j; p++) {
                    if (nodes[p].area == 1) {
                        count1++;
                    } else if (nodes[p].area == 2) {
                        count2++;
                    } else if (nodes[p].area == 3) {
                        count3++;
                    } else {
                        count4++;
                    }
                }
                ans += count1 * count2 + count2 * count3 + count3 * count4 + count4 * count1;
                i = j;
            }
        }
        return ans;
    }
}

class Node {
    int raw_x;
    int raw_y;
    int x;
    int y;
    double k;
    int area;  // 1234分别表示1234象限

    Node(int raw_x, int raw_y) {
        this.raw_x = raw_x;
        this.raw_y = raw_y;
    }

    void move(int offset_x, int offset_y) {
        x = raw_x - offset_x;
        y = raw_y - offset_y;
    }

    void save_area() {
        if (x >= 0 && y > 0) {
            area = 1;
        }
        if (y <= 0 && x > 0) {
            area = 2;
        }
        if (x <= 0 && y < 0) {
            area = 3;
        }
        if (y >= 0 && x < 0) {
            area = 4;
        }
    }

    boolean isArea1() {
        if (x == 0 && y == 0) {
            return true;
        }
        return x >= 0 && y > 0;
    }

    void turn() {
        y = -y;
        int tmp = x;
        x = y;
        y = tmp;
    }

    void cal_k() {
        if (x == 0 && y == 0) {
            k = 200000.0;
        } else if (x == 0) {
            k = 100000.0;
        } else {
            k = y * 1.0 / x;
        }
    }
}
