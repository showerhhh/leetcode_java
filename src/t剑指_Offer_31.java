import java.util.Stack;

public class tåæ_Offer_31 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_tåæ_Offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int curPopIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[curPopIndex]) {
                stack.pop();
                curPopIndex++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}