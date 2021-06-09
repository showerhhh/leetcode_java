import java.util.ArrayList;
import java.util.Arrays;

public class t剑指_Offer_38 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_38 {
    ArrayList<String> result = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    boolean[] used;

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] c = s.toCharArray();
        Arrays.sort(c);
        dfs(c, 0);

        //将ArrayList转成String[]
        String[] result_list = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result_list[i] = result.get(i);
        }
        return result_list;
    }

    void dfs(char[] c, int depth) {
        if (depth == c.length) {
            result.add(builder.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (used[i] || (i > 0 && c[i] == c[i - 1] && !used[i - 1])) {
                continue;
            }
            builder.append(c[i]);
            used[i] = true;
            dfs(c, depth + 1);
            used[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}