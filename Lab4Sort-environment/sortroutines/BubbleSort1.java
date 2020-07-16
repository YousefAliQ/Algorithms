package sortroutines;

import runtime.Sorter;

import java.util.Arrays;


public class BubbleSort1 extends Sorter {

    int[] arr;

    public int[] sort(int[] array) {
        this.arr = array;
        bubbleSort1();
        return arr;

    }

    private void bubbleSort1() {

        int len = arr.length;
        Boolean isSorted = false;
        for (int i = 0; i < len && !isSorted; ++i) {
            isSorted = true;
            for (int j = 0; j < len - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(j, j + 1);
                }
            }
        }
    }

    int[] swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;

    }

    public static void main(String[] args) {
        int[] test = {21, 13, 1, -22, 51, 5, 18};
        BubbleSort1 bs = new BubbleSort1();

        System.out.println(Arrays.toString(bs.sort(test)));

    }

}
