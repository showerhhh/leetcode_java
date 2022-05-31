public class t215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Solution_t215 solution = new Solution_t215();
        System.out.println(solution.findKthLargest(nums, k));
    }
}

class Solution_t215 {
    int[] heap;
    int n;

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for (int i = 0; i < k - 1; i++) {
            delete();
        }
        return delete();
    }

    void buildHeap(int[] nums) {
        n = nums.length;
        heap = new int[n + 1];
        System.arraycopy(nums, 0, heap, 1, n);
        for (int i = n / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    int delete() {
        int res = heap[1];
        swap(1, n);
        n--;
        heapify(1);
        return res;
    }

    void heapify(int i) {
        // 对i号节点向下调整
        int j = 2 * i;
        while (j <= n) {
            if (j + 1 <= n && heap[j + 1] > heap[j]) {
                j++;
            }
            if (heap[j] > heap[i]) {
                swap(i, j);
                i = j;
                j = 2 * i;
            } else {
                break;
            }
        }
    }

    void adjustUp(int i) {
        int j = i / 2;
        while (j >= 1) {
            if (heap[j] < heap[i]) {
                swap(i, j);
                i = j;
                j = i / 2;
            } else {
                break;
            }
        }
    }

    void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}