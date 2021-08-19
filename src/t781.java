import java.util.HashMap;

public class t781 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : answers) {
            if (!map.containsKey(num) || map.get(num) == 0) {
                map.put(num, num);
                count += num;
                count++;
            } else {
                map.put(num, map.get(num) - 1);
            }
        }
        return count;
    }
}