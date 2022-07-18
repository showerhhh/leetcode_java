public class t剑指_Offer_64 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_64 {
    int sum = 0;

    public int sumNums(int n) {
        // 借助与运算的短路效果实现递归的终止条件（sumNums(n - 1)>0没有实际意义，只是将返回值由int转变为boolean）
        boolean x = n >= 1 && sumNums(n - 1) > 0;
        sum += n;
        return sum;
    }
}