import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class selfAware {

    static List<int[]> selfAwareList;

    static void allPermutation(int[] possibleNumbers, int[] data, int last, int index) {
        int length = possibleNumbers.length;

        for (int i = 0; i < length; i++) {
            data[index] = possibleNumbers[i];

            if (index == last) {
                boolean isSelfAware = isSelfAware(data);
                if (isSelfAware) {
                    selfAwareList.add(data.clone());
                }
            } else allPermutation(possibleNumbers, data, last, index + 1);
        }
    }

    static List<int[]> allSelfAwareList(int number) {
        int length = number;
        int[] data = new int[length];
        int[] numbers = IntStream.rangeClosed(0, number - 1).toArray();
        allPermutation(numbers, data, length - 1, 0);
        return selfAwareList;
    }

    static boolean isSelfAware(int[] arr) {

        int indexCount = 0, arrayLength = arr.length;
        for (int i = 0; i < arr.length; i++) {
            indexCount = 0;
            for (int j = 0; j < arr.length; j++)
                if (arr[j] == i) indexCount++;
            if (indexCount != arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSelfAware(new int[]{2, 0, 2, 0}));
        System.out.println(isSelfAware(new int[]{3, 3, 3, 3}));

        selfAwareList = new ArrayList<>();
        allSelfAwareList(4);
        selfAwareList.stream().map(Arrays::toString).forEach(System.out::println);
    }


}