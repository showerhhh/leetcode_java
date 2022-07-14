package 蔚来笔试;

import java.util.HashSet;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        t1 t = new t1();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(t.f(x, y));
        }
    }

    String f(int x, int y) {
        int max = Math.max(x, y);
        int g = gcd(x, y);
        int count = max / g;
        if (count % 2 == 1) {
            return "A";
        } else {
            return "B";
        }
    }

    int gcd(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
