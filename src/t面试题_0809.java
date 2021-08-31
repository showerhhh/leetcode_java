import java.util.ArrayList;
import java.util.List;

public class t面试题_0809 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0809 {
    int n;
    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack("", 0, 0);
        return res;
    }

    void backtrack(String t, int left, int right) {
        if (left > n || right > n || right > left) {
            return;
        }
        if (t.length() == n * 2) {
            res.add(t);
            return;
        }
        backtrack(t + "(", left + 1, right);
        backtrack(t + ")", left, right + 1);
    }
}