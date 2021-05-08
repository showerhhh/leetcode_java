public class t剑指_Offer_40 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        int k = 6;
        Solution_t剑指_Offer_40 solution = new Solution_t剑指_Offer_40();
        int[] result = solution.getLeastNumbers(arr, k);
        for (int digit : result) {
            System.out.print(digit);
            System.out.print(" ");
        }
    }
}

class Solution_t剑指_Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        MinHeap heap = new MinHeap(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.pop();
        }
        return result;
    }

    class MinHeap {
        int[] nums;
        int n;  // 数组中有效元素的长度（堆的长度）：0,1~n
        int max_length;  // 数组长度

        public MinHeap(int[] arr) {
            n = arr.length;
            max_length = n + 1;
            nums = new int[max_length];
            nums[0] = -1;
            for (int i = 1; i <= n; i++) {
                nums[i] = arr[i - 1];
            }
            buildHeap();
        }

        void buildHeap() {
            for (int i = n / 2; i > 0; i--) {
                adjustDown(i);
            }
        }

        int pop() {
            //删除元素
            int tmp = nums[1];  // tmp暂存
            nums[1] = nums[n];
            n--;
            adjustDown(1);
            return tmp;
        }

        void pull(int digit) {
            //加入元素
            if (n >= max_length - 1) {  // 没有额外空间，重新分配内存
                max_length *= 2;
                int[] tmp = new int[max_length];
                tmp[0] = -1;
                for (int i = 1; i <= n; i++) {
                    tmp[i] = nums[i];
                }
                nums = tmp;
            }
            n++;
            nums[n] = digit;
            adjustUp(n);
        }

        void adjustDown(int k) {
            //在k号节点处向下调整
            for (int i = 2 * k; i <= n; i *= 2) {
                if (i + 1 <= n && nums[i + 1] < nums[i])
                    i++;  // i指向较小的子节点

                if (nums[i] < nums[k]) {
                    swap(i, k);
                    k = i;
                } else {
                    break;
                }
            }
        }

        void adjustUp(int k) {
            //在k号节点处向上调整
            for (int i = k / 2; i >= 1; i /= 2) {
                if (nums[k] < nums[i]) {
                    swap(i, k);
                    k = i;
                } else {
                    break;
                }
            }
        }

        void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

