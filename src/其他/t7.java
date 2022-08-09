package 其他;

import java.util.ArrayList;

public class t7 {

    public static void main(String[] args) {
        t7 t = new t7();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(7);
        l1.add(8);
        l1.add(9);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(7);
        l2.add(7);
        System.out.println(t.multi(l1, l2));
    }

    ArrayList<Integer> multi(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            // l1.get(i)乘l2
            int n = l1.get(i);
            int carry = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < l2.size(); j++) {
                int m = l2.get(j) * n + carry;
                tmp.add(m % 10);
                carry = m / 10;
            }
            while (carry != 0) {
                tmp.add(carry % 10);
                carry /= 10;
            }
            // tmp加到res中（从res[i]位置开始）
            carry = 0;
            for (int j = 0; j < tmp.size(); j++) {
                if (j + i < res.size()) {
                    int add = tmp.get(j) + res.get(j + i) + carry;
                    res.set(j + i, add % 10);
                    carry = add / 10;
                } else {
                    int add = tmp.get(j) + carry;
                    res.add(add % 10);
                    carry = add / 10;
                }
            }
            while (carry != 0) {
                res.add(carry % 10);
                carry /= 10;
            }
        }
        return res;
    }
}
