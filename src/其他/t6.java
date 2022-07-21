package 其他;

import java.util.ArrayList;

public class t6 {

    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        t6 t = new t6();
        System.out.println(t.f(10));
    }

    String f(int n) {
        // 求n的阶乘，会很大，用String保存
        list.add(1);
        for (int i = 2; i <= n; i++) {
            multi(i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.insert(0, list.get(i));
        }
        return builder.toString();
    }

    void multi(int n) {
        // list中的数字乘n
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int res = list.get(i) * n + carry;
            list.set(i, res % 10);
            carry = res / 10;
        }
        while (carry != 0) {
            list.add(carry % 10);
            carry /= 10;
        }
    }
}

