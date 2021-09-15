import java.util.Stack;

public class t面试题_1616 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1616 {
    public int[] subSort(int[] array) {
        Stack<Integer> digit = new Stack<>();
        Stack<Integer> index = new Stack<>();

        // 从前向后遍历，建立不严格递增单调栈
        for (int i = 0; i < array.length; i++) {
            while (!digit.isEmpty() && array[i] < digit.peek()) {
                digit.pop();
                index.pop();
            }
            digit.push(array[i]);
            index.push(i);
        }
        //确定m的位置
        int m = -1;
        if (!index.isEmpty() && index.get(0) != 0) {
            m = 0;
        } else {
            for (int i = 0; i < index.size() - 1; i++) {
                if (index.get(i) + 1 != index.get(i + 1)) {
                    m = index.get(i) + 1;
                    break;
                }
            }
        }

        digit.clear();
        index.clear();

        // 从后向前遍历，建立不严格递减单调栈
        for (int i = array.length - 1; i >= 0; i--) {
            while (!digit.isEmpty() && array[i] > digit.peek()) {
                digit.pop();
                index.pop();
            }
            digit.push(array[i]);
            index.push(i);
        }
        //确定n的位置
        int n = -1;
        if (!index.isEmpty() && index.get(0) != array.length - 1) {
            n = array.length - 1;
        } else {
            for (int i = 0; i < index.size() - 1; i++) {
                if (index.get(i) - 1 != index.get(i + 1)) {
                    n = index.get(i) - 1;
                    break;
                }
            }
        }

        if (m < n) {
            return new int[]{m, n};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] subSort_2(int[] array) {
        int m = -1, curMin = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > curMin) {
                m = i;
            } else {
                curMin = array[i];
            }
        }

        int n = -1, curMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < curMax) {
                n = i;
            } else {
                curMax = array[i];
            }
        }

        return new int[]{m, n};
    }
}