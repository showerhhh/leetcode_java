import java.util.ArrayList;
import java.util.List;

public class t77 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t77 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k);
        return res;
    }

    void backtrack(int curNum, ArrayList<Integer> list, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = curNum; i <= n; i++) {  // curNum为当前所有选择的起始位置
            list.add(i);
            backtrack(i + 1, list, n, k);
            list.remove(list.size() - 1);
        }
    }

    void backtrack_2(int curNum, ArrayList<Integer> list, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (curNum > n) {
            return;
        }
        // 不选curNum
        backtrack(curNum + 1, list, n, k);
        // 选curNum
        list.add(curNum);
        backtrack(curNum + 1, list, n, k);
        list.remove(list.size() - 1);
    }
}