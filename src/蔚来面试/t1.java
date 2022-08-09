package 蔚来面试;

import java.util.*;

public class t1 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1 {
    public List<String> invalidTransactions(String[] transactions) {
        Trans[] a = new Trans[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] trans = transactions[i].split(",");
            a[i] = new Trans(i, trans[0], Integer.parseInt(trans[1]), Integer.parseInt(trans[2]), trans[3]);
        }
        Arrays.sort(a, new Comparator<Trans>() {
            @Override
            public int compare(Trans o1, Trans o2) {
                return o1.time - o2.time;
            }
        });
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i].amount > 1000) {
                set.add(a[i].id);
            }
            int j = i + 1;
            while (j < a.length && a[j].time - a[i].time <= 60) {
                if (!a[j].city.equals(a[i].city) && a[j].name.equals(a[i].name)) {
                    set.add(a[i].id);
                    set.add(a[j].id);
                }
                j++;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int id : set) {
            res.add(transactions[id]);
        }
        return res;
    }

    class Trans {
        int id;
        String name;
        int time;
        int amount;
        String city;

        public Trans(int id, String name, int time, int amount, String city) {
            this.id = id;
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
}

