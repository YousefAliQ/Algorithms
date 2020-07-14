public class SelectionSort {

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }
            swap(array, i, min);
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

        int[] sortedArray = selectionSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }

    }
}
