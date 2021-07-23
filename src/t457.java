import java.util.HashSet;

public class t457 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();  // 存一次循环所访问过的下标
            int curIndex = i;
            String orient;
            if (nums[curIndex] > 0) {
                orient = "right";
            } else {
                orient = "left";
            }
            boolean flag = false;  // 标记方向是否发生了改变
            while (!set.contains(curIndex)) {
                set.add(curIndex);
                int n = Math.abs(nums[curIndex]) / nums.length + 1;
                curIndex = (curIndex + nums[curIndex] + n * nums.length) % nums.length;
                // 判断方向是否发生了改变
                if ((orient.equals("right") && nums[curIndex] < 0) || (orient.equals("left") && nums[curIndex] > 0)) {
                    flag = true;
                    break;
                }
            }
            if (curIndex == i && !flag && set.size() > 1) {
                return true;
            }
        }
        return false;
    }
}