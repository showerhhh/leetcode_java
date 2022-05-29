import java.util.HashMap;

public class t904 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t904 {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxLength = 0;
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            r++;
            while (check(map) && l < r) {  // 当窗口不满足题意时，l指针左移
                map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l);
        }
        return maxLength;
    }

    boolean check(HashMap<Integer, Integer> map) {
        int t = 0;
        for (int val : map.values()) {
            if (val > 0) {
                t++;
            }
            if (t > 2) {
                return true;
            }
        }
        return false;
    }

    public int totalFruit_2(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxLength = 0;
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            r++;
            while (map.size() > 2 && l < r) {  // 当窗口不满足题意时，l指针左移
                map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                if (map.get(fruits[l]) <= 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l);
        }
        return maxLength;
    }
}