import java.util.ArrayList;
import java.util.Arrays;

public class GoofySort {
    public static void main(String[] args) {

        int[] arr = new int[]{3,2,1,6,6,7,5,3};
        int sortedArr[] = Goofy(arr);

        for(int i=0; i<sortedArr.length; i++){
            System.out.println(sortedArr[i]);
        }

    }

    public static int[] Goofy(int[] arr){

        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }

        if (isSortedArray(temp)) return temp;

        while(!isSortedArray(temp)){
            System.out.println("Starting again ... ");
            temp = permuteArrayRandomly(temp);
        }

        return temp;
    }

    private static int[] permuteArrayRandomly(int[] arr) {

        System.out.println("Permute Array Randomly ... ");
        int[] temp = new int[arr.length];
        int[] randomNumbers = generateRandomNumbers(arr.length);
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[randomNumbers[i]];
        }
        return temp;
    }

    private static int[] generateRandomNumbers(int length) {

        System.out.println("Generate Random Numbers ... ");


        ArrayList<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++){
            list.add(i);
        }
        int[] randoms = new int[length];
        for (int count = 0; count < length; count++){
            randoms[count] = list.remove((int)(Math.random() * list.size()));
        }

        return randoms;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static boolean isSortedArray(int[] arr){
        System.out.println("Checking is sorted array ... ");
        boolean sorted = true;
        for(int i=0; i<arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
