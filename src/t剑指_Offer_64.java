public class t剑指_Offer_64 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_64 {
    int sum = 0;

    public int sumNums(int n) {
        f(n);
        return sum;
    }

    boolean f(int n) {
        boolean x = n >= 1 && f(n - 1);
        sum += n;
        return true;
    }
}