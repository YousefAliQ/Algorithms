import java.util.ArrayList;
import java.util.List;

public class KnapsackGreedy {

    public static void main(String args[]) {
        KnapsackGreedy kg = new KnapsackGreedy();

        List<Item> items = new ArrayList<Item>();

        Item item0 = new Item(0, 1, 4);
        Item item1 = new Item(1, 2, 1);
        Item item2 = new Item(2, 4, 3);

        items.add(item0);
        items.add(item1);
        items.add(item2);

        items.sort((o1, o2) -> {
            return o1.getW() > o2.getW() ? o1.getW() : o2.getW();
        });

        Integer W = 4;

        List<Item> result = kg.Knapsack(items, W);

        for (Item item : result) {
            System.out.println(item);
        }
    }

    public <T> List<Item> Knapsack(List<Item> s, Integer W) {

        List<Item> maxLimit = new ArrayList<>();
        Integer max = 0;
        for (int i = 0; i < s.size(); i++) {
            if (max + s.get(i).getW() <= W) {
                max += s.get(i).getW();
                maxLimit.add(s.get(i));
            } else {
                break;
            }
        }
        return maxLimit;
    }

    /**
     * Greedy code is to find the closest solution to the best one
     * But It will not give you the best one always.
     * It's used to minimize the complexity from 2^n to n*log n.
     */

}
