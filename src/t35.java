public class t35 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t35 {
    public int searchInsert(int[] nums, int target) {
        // nums={ 1,2,3,3,3,3,4,5 } target=3
        // 1,2(right),3(left),3,3,3,4,5

        // nums={1,2,4,5} target=3
        // 1,2(right),4(left),5

        // 由此可见，当相等分支合并到左移分支时，left指针指向第一个target或将target夹在中间
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}