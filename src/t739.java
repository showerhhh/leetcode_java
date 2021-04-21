import java.util.ArrayList;

public class t739 {
    public static void main(String[] args) {
        Solution_t739 solution = new Solution_t739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(T);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution_t739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 0;
        }
        ArrayList<Integer> stack = new ArrayList<Integer>();  // 存下标
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.get(stack.size() - 1)]) {
                int index = stack.remove(stack.size() - 1);
                result[index] = i - index;
            }
            stack.add(i);
        }
        return result;
    }
}