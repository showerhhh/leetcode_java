import java.util.HashMap;
import java.util.Map;

public class t846 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t846 {
    HashMap<Integer, Integer> map = new HashMap<>();  // key为牌，value为该张牌的个数

    public boolean isNStraightHand(int[] hand, int groupSize) {
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        int startCard = findMinCard();
        while (startCard != Integer.MAX_VALUE) {
            // 删除从startCard开始的groupSize张牌
            for (int i = 0; i < groupSize; i++) {
                int card = startCard + i;
                int count = map.getOrDefault(card, 0);
                if (count <= 0) {
                    return false;
                }
                map.put(card, count - 1);
            }
            startCard = findMinCard();
        }
        return true;
    }

    int findMinCard() {
        int minCard = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int card = entry.getKey();
            int count = entry.getValue();
            if (count != 0 && card < minCard) {
                minCard = card;
            }
        }
        return minCard;
    }
}