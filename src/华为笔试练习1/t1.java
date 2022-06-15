package 华为笔试练习1;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t1 t = new t1();
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(t.f(n));
        }
    }

    int f(int n) {
        int count = 0;
        while (n >= 2) {
            int x = n / 3;
            int y = n % 3;
            if (y == 0 || y == 1) {
                count += x;
                n = x + y;
            } else {
                count += x + 1;
                n = x;
            }
        }
        return count;
    }
}
