public class t12 {
    public static void main(String[] args) {
        int num = 1994;
        Solution_t12 solution = new Solution_t12();
        System.out.println(solution.intToRoman(num));
    }
}

class Solution_t12 {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        for (int i = 0; i < symbols.length; i++) {
            while (value[i] <= num) {
                result += symbols[i];
                num -= value[i];
            }
            if (num == 0) {
                break;
            }
        }
        return result;
    }
}