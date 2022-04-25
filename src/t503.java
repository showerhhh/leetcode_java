import java.util.Stack;

public class t503 {
    public static void main(String[] args) {
        int[] num = {2, 3, 1};
        Solution_t503 solution = new Solution_t503();
        int[] result = solution.nextGreaterElements(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution_t503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();  // 存下标
        int n = nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]) {
                int idx = stack.pop();
                result[idx % n] = nums[i % n];
            }
            stack.push(i);
        }
        return result;
    }
}