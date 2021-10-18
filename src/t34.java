public class t34 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t34 {
    public int[] searchRange(int[] nums, int target) {
        int tagl = -1, tagr = -1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // nums={ 1,2,3,3,3,3,4,5 } target=3
        // 1,2(right),3(left),3,3,3,4,5

        // nums={1,2,4,5} target=3
        // 1,2(right),4(left),5

        // 由此可见，当相等分支合并到左移分支时，left指针指向第一个target或target应该插入的位置
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            tagl = left;
        }

        // nums={ 1,2,3,3,3,3,4,5 } target=3
        // 1,2,3,3,3,3(right),4(left),5

        // nums={1,2,4,5} target=3
        // 1,2(right),4(left),5

        // 由此可见，当相等分支合并到右移分支时，right指针指向第一个target或target应该（向前）插入的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            tagr = right;
        }

        return new int[]{tagl, tagr};
    }
}