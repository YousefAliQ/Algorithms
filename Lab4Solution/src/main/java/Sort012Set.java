public class Sort012Set {

    private static int[] setSort(int[] array) {
        int zeroCounter = 0;
        int oneCounter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) zeroCounter++;
            else if (array[i] == 1) oneCounter++;
        }

        for (int i = 0; i < array.length; i++) {
            if (zeroCounter != 0) {
                array[i] = 0;
                zeroCounter--;
            } else if (oneCounter != 0) {
                array[i] = 1;
                oneCounter--;
            } else {
                array[i] = 2;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, 1, 2, 2, 1};

        int[] sortedArray = setSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }
    }
}
