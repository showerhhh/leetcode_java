import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();  // 存下标
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.add(i);
        }
        return result;
    }
}