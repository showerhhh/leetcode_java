import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class t380 {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.remove(0);
        boolean param_2 = obj.remove(0);
        boolean param_3 = obj.insert(0);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(0);
        boolean param_6 = obj.insert(0);
        System.out.println("test");
    }
}

class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            int lastItem = list.get(list.size() - 1);
            list.set(idx, lastItem);
            map.put(lastItem, idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */