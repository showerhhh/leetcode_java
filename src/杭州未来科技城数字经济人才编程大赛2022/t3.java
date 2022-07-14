package 杭州未来科技城数字经济人才编程大赛2022;

import java.util.ArrayList;
import java.util.Arrays;

public class t3 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t3 {
    public int buildTransferStation(int[][] area) {
        ArrayList<Integer> list_x = new ArrayList<>();
        ArrayList<Integer> list_y = new ArrayList<>();
        int m = area.length, n = area[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 1) {
                    list_x.add(i);
                    list_y.add(j);
                }
            }
        }
        int[] nums_x = new int[list_x.size()];
        for (int i = 0; i < nums_x.length; i++) {
            nums_x[i] = list_x.get(i);
        }
        int[] nums_y = new int[list_y.size()];
        for (int i = 0; i < nums_y.length; i++) {
            nums_y[i] = list_y.get(i);
        }
        return minDistance(nums_x) + minDistance(nums_y);
    }

    int minDistance(int[] nums) {
        // 返回到数组中所有点的距离的最小值
        Arrays.sort(nums);
        int a = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - a);
        }
        return res;
    }
}