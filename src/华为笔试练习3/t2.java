package 华为笔试练习3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class t2 {
    boolean[] used;
    ArrayList<ArrayList<Integer>> res;

    public static void main(String[] args) {
        t2 t = new t2();
        int[] nums = new int[]{75, 36, 10, 4, 30, 225, 90, 25, 12};
        t.f(nums);
    }

    ArrayList<ArrayList<Integer>> f(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[9];
        backtracking(nums, new ArrayList<>());
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < 9; i++) {
                    int t = o1.get(i) - o2.get(i);
                    if (t != 0) {
                        return t;
                    }
                }
                return 0;
            }
        });
        return res;
    }

    void backtracking(int[] nums, ArrayList<Integer> list) {
        if (list.size() == 9) {
            if (check(list)) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (list.size() > 9) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                backtracking(nums, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    boolean check(ArrayList<Integer> list) {
        int digit = 1;
        for (int i = 0; i < 3; i++) {
            digit *= list.get(i);
        }
        // 行
        for (int i = 0; i < 3; i++) {
            int nums = 1;
            for (int j = 0; j < 3; j++) {
                nums *= list.get(i * 3 + j);
            }
            if (nums != digit) {
                return false;
            }
        }
        // 列
        for (int j = 0; j < 3; j++) {
            int nums = 1;
            for (int i = 0; i < 3; i++) {
                nums *= list.get(i * 3 + j);
            }
            if (nums != digit) {
                return false;
            }
        }
        // 对角线
        if (list.get(0) * list.get(4) * list.get(8) != digit) {
            return false;
        }
        if (list.get(2) * list.get(4) * list.get(6) != digit) {
            return false;
        }
        return true;
    }
}
