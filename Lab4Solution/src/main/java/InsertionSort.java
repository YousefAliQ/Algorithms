public class InsertionSort {


    private static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int hole = i;

            while (hole > 0 && array[hole - 1] > value) {
                array[hole] = array[hole - 1];
                hole = hole - 1;
            }
            array[hole] = value;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 6, 7, 8, 5, 7};

        int[] sortedArray = insertionSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }
    }

}
