import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<Integer> stack = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.get(stack.size() - 1)) {
                int k = stack.remove(stack.size() - 1);
                int v = nums2[i];
                map.put(k, v);
            }
            stack.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}