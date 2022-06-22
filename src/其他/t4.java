package 其他;

public class t4 {
    void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2 + low;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(int[] nums, int low, int mid, int high) {
        int[] T = new int[high - low + 1];  //临时数组
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                T[k++] = nums[i++];
            } else {
                T[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            T[k++] = nums[i++];
        }
        while (j <= high) {
            T[k++] = nums[j++];
        }
        //复制
        System.arraycopy(T, 0, nums, low, T.length);
    }
}
