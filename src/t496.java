import java.util.HashMap;
import java.util.Stack;

public class t496 {
    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        Solution_t496 solution = new Solution_t496();
        int[] result = solution.nextGreaterElement(num1, num2);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution_t496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int idx = stack.pop();
                map.put(nums2[idx], nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}