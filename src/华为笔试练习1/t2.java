package 华为笔试练习1;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bucket = new int[501];
        for (int i = 0; i < n; i++) {
            bucket[sc.nextInt()] = 1;
        }
        for (int i = 1; i <= 500; i++) {
            if (bucket[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
