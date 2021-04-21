import java.util.ArrayList;

public class t901 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class StockSpanner {
    ArrayList<Integer> stack;
    ArrayList<Integer> assist;

    public StockSpanner() {
        stack = new ArrayList<>();
        assist = new ArrayList<>();
    }

    public int next(int price) {
        int w = 1;
        while (!stack.isEmpty() && price >= stack.get(stack.size() - 1)) {
            stack.remove(stack.size() - 1);
            w += assist.remove(assist.size() - 1);
        }
        stack.add(price);
        assist.add(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */