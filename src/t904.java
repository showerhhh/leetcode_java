import java.util.HashMap;

public class t904 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t904 {
    public int totalFruit(int[] fruits) {
        int i = 0, maxLength = 0;
        HashMap<Integer, Integer> count = new HashMap<>();  // count中存放数字出现的个数
        // 外层循环控制右边界每次前进一位
        for (int j = 0; j < fruits.length; j++) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            // 内层循环控制左边界不断前进
            while (count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                if (count.get(fruits[i]) == 0) {
                    count.remove(fruits[i]);
                }
                i++;
            }
            // 在外层循环中，窗口符合要求，记录最大值
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}