public class t面试题_1601 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public int[] swapNumbers_2(int[] numbers) {
        //异或性质：
        //a^0=a
        //a^a=0
        //a^b=b^a
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}