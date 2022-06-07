import java.util.HashMap;

public class t621 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }
        int maxNums = 0;
        for (int count : map.values()) {
            if (count == maxCount) {
                maxNums++;
            }
        }
        int time = Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxNums);
        return time;
    }
}