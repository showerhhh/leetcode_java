package 第257场周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class t1996 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] > o2[1]) {
                        return -1;
                    } else if (o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = properties.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= properties[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res++;
            }
            stack.push(properties[i][1]);
        }
        return res;
    }
}