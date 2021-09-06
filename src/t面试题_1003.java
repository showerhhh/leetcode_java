public class t面试题_1003 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1003 {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return findMinIndex(arr, target, mid);
            }
            if (arr[left] == arr[mid]) {
                left++;
            } else if (arr[left] < arr[mid]) {
                // 左侧有序
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧有序
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    int findMinIndex(int[] arr, int target, int mid) {
        if (arr[0] == target) {
            return 0;
        } else {
            while (arr[mid] == target) {
                mid--;
            }
            return mid + 1;
        }
    }
}