package sortroutines;

import runtime.Sorter;

import java.util.Arrays;


public class BubbleSort2 extends Sorter {

    int[] arr;

    public int[] sort(int[] array) {
        this.arr = array;
        bubbleSort2();
        return arr;

    }

    private void bubbleSort2() {

        int len = arr.length;
        int lastUnsorted = arr.length - 1;

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < lastUnsorted; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
            lastUnsorted--;
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
        BubbleSort2 bs = new BubbleSort2();

        System.out.println(Arrays.toString(bs.sort(test)));

    }

}
