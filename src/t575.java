import java.util.HashSet;

public class t575 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t575 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        int t = set.size();
        int n_2 = candyType.length / 2;
        if (t >= n_2) {
            return n_2;
        } else {
            return t;
        }
    }
}