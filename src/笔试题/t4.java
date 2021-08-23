package 笔试题;

import java.util.Scanner;

public class t4 {
    static String res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] params = scanner.nextLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int k = Integer.parseInt(params[1]);
            String s = scanner.nextLine();
            res = s.substring(0, k);
            backtrack(n, k, s, 0, new StringBuilder());
            System.out.println(res);
        }
    }

    static void backtrack(int n, int k, String s, int startidx, StringBuilder builder) {
        if (builder.length() == k) {
            String tmp = builder.toString();
            if (tmp.compareTo(res) > 0) {
                res = tmp;
            }
            return;
        }
        for (int i = startidx; i < n; i++) {
            builder.append(s.charAt(i));
            backtrack(n, k, s, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
