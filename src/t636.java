import java.util.List;
import java.util.Stack;

public class t636 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<int[]>();
        int[] result = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int id = Integer.valueOf(log[0]);
            String act = log[1];
            int time = Integer.valueOf(log[2]);

            if (act.equals("start")) {
                stack.push(new int[]{id, time});
            } else {
                int[] last = stack.pop();
                int during_time = time - last[1] + 1;  // during_time计算了该函数从开始到结束的时间，包括中间的中断时间
                result[last[0]] += during_time;  // 已经减去了下层函数的during_time，所以可以直接加上本层函数的during_time
                //栈非空时，上一层函数的持续时间减去during_time
                if (!stack.isEmpty()) {
                    result[stack.peek()[0]] -= during_time;
                }
            }
        }
        return result;
    }

    public int[] exclusiveTime_2(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[n];
        int t = 0;  // t保存栈顶元素本段开始运行的时刻
        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int id = Integer.valueOf(log[0]);
            String act = log[1];
            int time = Integer.valueOf(log[2]);

            if (act.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - t;
                }
                stack.push(id);
                t = time;
            } else {
                result[stack.pop()] += time - t + 1;
                t = time + 1;
            }
        }
        return result;
    }
}