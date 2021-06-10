public class t剑指_Offer_46 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_46 {
    int count = 0;

    public int translateNum(int num) {
        dfs(num);
        return count;
    }

    void dfs(int num) {
        if (num < 10) {
            count++;
            return;
        }

        if (num % 100 <= 25 && num % 100 >= 10) {
            // 若末尾两位在[10,25]之间，则可以选择两位翻译，也可以选择一位翻译
            dfs(num / 10);
            dfs(num / 100);
        } else {
            // 否则，只能选择一位翻译
            dfs(num / 10);
        }
    }
}