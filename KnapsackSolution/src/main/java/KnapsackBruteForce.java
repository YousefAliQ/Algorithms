import java.util.*;

public class KnapsackBruteForce {

    public List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), numbers, 0);
        return list;
    }

    private void subsetsHelper(List<List<Integer>> list, List<Integer> resultList, int[] numbers, int start) {
        list.add(new ArrayList<>(resultList));
        for (int i = start; i < numbers.length; i++) {
            resultList.add(numbers[i]);
            subsetsHelper(list, resultList, numbers, i + 1);
            resultList.remove(resultList.size() - 1);
        }
    }

    public <T> List<Integer> Knapsack(List<List<Integer>> s, Integer v[], Integer w[], Integer W) {

        List<Integer> max = new ArrayList<>();
        Integer maxValue = 0;
        for (int i = 0; i < s.size(); i++) {
            int tempValue = 0;
            int tempWeight = 0;

            for (int j = 0; j < s.get(i).size(); j++) {
                tempValue += v[s.get(i).get(j)];
                tempWeight += w[s.get(i).get(j)];
            }

            if (tempWeight <= W) {
                if (tempValue > maxValue) {
                    maxValue = tempValue;
                    max = s.get(i);
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        KnapsackBruteForce kbf = new KnapsackBruteForce();
        int[] numbers = {0, 1, 2};
        List<List<Integer>> subsets = kbf.subsets(numbers);

        Integer v[] = {1, 3, 4};
        Integer w[] = {1, 2, 4};
        Integer W = 4;

        List<Integer> result = kbf.Knapsack(subsets, v, w, W);

        for (Integer item : result) {
            System.out.println(item);
        }
    }
}
