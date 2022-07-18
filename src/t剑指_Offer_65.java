public class t剑指_Offer_65 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_65 {
    public int add(int a, int b) {
        int s = a ^ b;
        int c = (a & b) << 1;
        if (c != 0) {
            return add(s, c);
        } else {
            return s;
        }
    }
}