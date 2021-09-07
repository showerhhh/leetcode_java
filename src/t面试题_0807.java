import java.util.ArrayList;

public class t面试题_0807 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0807 {
    boolean[] visited;

    public String[] permutation(String S) {
        visited = new boolean[S.length()];
        ArrayList<String> res = new ArrayList<>();
        backtrack("", res, S);
        return res.toArray(new String[0]);
    }

    void backtrack(String t, ArrayList<String> res, String s) {
        if (t.length() == s.length()) {
            res.add(t);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(t + s.charAt(i), res, s);
                visited[i] = false;
            }
        }
    }
}