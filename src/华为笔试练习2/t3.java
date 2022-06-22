package 华为笔试练习2;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] s_list = s.split("-");
            Cards c1 = new Cards(s_list[0]);
            Cards c2 = new Cards(s_list[1]);
            Cards big = Cards.compare(c1, c2);
            if (big != null) {
                System.out.println(big.cards);
            } else {
                System.out.println("ERROR");
            }
        }
    }
}

class Cards {
    String type;
    int weight;
    String cards;
    String map = "345678910JQKA2jokerJOKER";

    public Cards(String cards) {
        this.cards = cards;
        String[] cards_list = cards.split(" ");
        if (cards_list.length == 5) {
            type = "shun";
        } else if (cards_list.length == 4) {
            type = "bomb";
        } else if (cards_list.length == 3) {
            type = "triple";
        } else if (cards_list.length == 2) {
            if (cards_list[0].equals("joker") || cards_list[0].equals("JOKER")) {
                type = "bomb";
            } else {
                type = "pair";
            }
        } else {
            type = "single";
        }
        weight = map.indexOf(cards_list[cards_list.length - 1]);
    }

    static Cards compare(Cards c1, Cards c2) {
        // 返回较大的手牌
        if (c1.type.equals("bomb") && !c2.type.equals("bomb")) {
            return c1;
        } else if (!c1.type.equals("bomb") && c2.type.equals("bomb")) {
            return c2;
        } else if (c1.type.equals(c2.type)) {
            if (c1.weight > c2.weight) {
                return c1;
            } else {
                return c2;
            }
        } else {
            return null;
        }
    }
}