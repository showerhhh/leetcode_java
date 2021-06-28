package 第247场周赛;

public class t5797 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5797 {
    public int maxProductDifference(int[] nums) {
        int max = 0;
        int second_max = 0;
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                second_min = min;
                min = nums[i];
            } else if (nums[i] < second_min) {
                second_min = nums[i];
            }

            if (nums[i] > max) {
                second_max = max;
                max = nums[i];
            } else if (nums[i] > second_max) {
                second_max = nums[i];
            }
        }
        return max * second_max - min * second_min;
    }
}