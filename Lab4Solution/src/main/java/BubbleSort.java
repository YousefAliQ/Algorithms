public class BubbleSort {

    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int lastUnsorted = array.length - 1;

            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 6, 7, 8, 5, 7};

        int[] sortedArray = bubbleSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }
    }
}
