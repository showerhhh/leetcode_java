import java.util.Random;

public class t470 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */
class SolBase {
    Random rand = new Random();

    public int rand7() {
        return rand.nextInt(7) + 1;
    }
}

class Solution_t470 extends SolBase {
    public int rand10() {
        int x, y, gen;
        do {
            x = rand7();
            y = rand7();
            gen = x + (y - 1) * 7;
        } while (gen > 40);
        gen = (gen - 1) % 10 + 1;
        return gen;
    }
}