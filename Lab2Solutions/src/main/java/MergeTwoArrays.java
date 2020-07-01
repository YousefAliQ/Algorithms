import java.lang.reflect.Array;

public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 8, 17};
        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};

        int[] result = merge(arr1, arr2);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " , ");
        }
    }

    public  static int[] merge(int[] arr1, int[] arr2){

        //TODO: check for inputs validation

        if ( arr1 == null || arr2 == null ) throw new IllegalArgumentException();

        if (arr1.length == 0) return arr2;
        if (arr2.length == 0) return arr1;

        int[] mergedArray = new int[arr1.length + arr2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int index=0;

        // TODO : clean the code !
        while (firstIndex <= arr1.length && secondIndex <= arr2.length){

            if (firstIndex == arr1.length){
                for(int i=secondIndex; i<arr2.length; i++){
                    mergedArray[index++] = arr2[i];
                }
                break;
            }

            if (secondIndex == arr2.length){
                for(int i=firstIndex; i<arr1.length; i++){
                    mergedArray[index++] = arr1[i];
                }
                break;
            }

            if (arr1[firstIndex] < arr2[secondIndex] ){
                mergedArray[index++] = arr1[firstIndex++];
            }else if ( arr1[firstIndex] > arr2[secondIndex] ){
                mergedArray[index++] = arr2[secondIndex++];
            }else {
                mergedArray[index++] = arr1[firstIndex++];
                mergedArray[index++] = arr2[secondIndex++];
            }
        }

        return mergedArray;
    }
}
