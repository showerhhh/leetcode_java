import java.util.HashMap;
import java.util.Map;

public class t594 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int countX = entry.getValue();
            int countX1 = map.getOrDefault(x + 1, 0);
            if (countX1 != 0 && countX1 + countX > maxLength) {
                maxLength = countX1 + countX;
            }
        }
        return maxLength;
    }
}