package 笔试题;

import java.util.ArrayList;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        t1 t = new t1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] inputs = line.split(",|\\{|}");
            int m = Integer.parseInt(inputs[0]);
            ArrayList<Integer> vals = new ArrayList<>();
            for (int i = 1; i < inputs.length; i++) {
                if (!inputs[i].equals("")) {
                    vals.add(Integer.parseInt(inputs[i]));
                }
            }
            System.out.println(t.output(t.func(vals, m)));
        }
    }

    ArrayList<Integer>[] func(ArrayList<Integer> vals, int m) {
        ArrayList<Integer>[] res = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            res[i] = new ArrayList<>();
        }
        for (int val : vals) {
            res[val % m].add(val);
        }
        return res;
    }

    String output(ArrayList<Integer>[] lists) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (ArrayList<Integer> list : lists) {
            builder.append("{");
            for (int num : list) {
                builder.append(num);
                builder.append(",");
            }
            if (!list.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("},");
        }
        if (lists.length != 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }
}
