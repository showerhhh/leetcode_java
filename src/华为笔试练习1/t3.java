package 华为笔试练习1;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t3 t = new t3();
        while (sc.hasNextLine()) {
            System.out.println(t.f(sc.nextLine()));
        }
    }

    int f(String s) {
        int res = 0;
        char[] t = s.toCharArray();
        for (int i = 2; i < t.length; i++) {
            if (t[i] >= '0' && t[i] <= '9') {
                res = res * 16 + t[i] - '0';
            } else {
                res = res * 16 + t[i] - 'A' + 10;
            }
        }
        return res;
    }
}
