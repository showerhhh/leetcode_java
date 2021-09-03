import java.util.Arrays;

public class t面试题_1714 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1714 {
    public int[] smallestK(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] smallestK_2(int[] arr, int k) {
        MinHeap h = new MinHeap(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = h.getMin();
        }
        return res;
    }

    static class MinHeap {
        int[] a;
        int n;

        MinHeap(int[] arr) {
            n = arr.length;
            a = new int[n + 1];
            System.arraycopy(arr, 0, a, 1, n);
            for (int i = n / 2; i >= 1; i--) {
                down(i);
            }
        }

        private void down(int i) {
            int j = 2 * i;
            while (j <= n) {
                if (j + 1 <= n && a[j + 1] < a[j]) {
                    j++;
                }
                if (a[i] <= a[j]) {
                    return;
                }
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i = j;
                j = 2 * i;
            }
        }

        public int getMin() {
            int tmp = a[1];
            a[1] = a[n];
            n--;
            down(1);
            return tmp;
        }
    }
}