import java.util.Random;
import java.util.*;

public class MergeSort {
    final int ARRAY_SIZE = 200;
    final int MAX_VAL = 1000;
    int[] theArray;


    //public sorter
    public int[] sort(int[] input){
        int n = input.length;
        int[] tempStorage = new int[n];
        theArray = input;
        mergeSort(tempStorage,0,n-1);
        return theArray;
    }


    /** Merges the ranges [lowerPointer,upperPointer-1] and [upperPointer,upperBound] in place */
    private void merge(int[] tempStorage, int lowerPointer, int upperPointer, int upperBound) {
        int j = 0; //tempStorage index
        int lowerBound = lowerPointer;
        int n = upperBound - lowerBound + 1; //total number of elements to rearrange

        //view the range [lowerBound,upperBound] as two arrays
        //[lowerBound, mid], [mid+1,upperBound] to be merged
        int mid = upperPointer -1;

        while(lowerPointer <= mid && upperPointer <= upperBound){
            if(theArray[lowerPointer] < theArray[upperPointer]){
                tempStorage[j++] = theArray[lowerPointer++];
            }
            else {
                tempStorage[j++] = theArray[upperPointer++];
            }
        }
        //left array may still have elements -- insert them into tempStorage
        while(lowerPointer <= mid) {
            tempStorage[j++] = theArray[lowerPointer++];
        }
        //right array may still have elements -- insert these into tempStorage
        while(upperPointer <= upperBound){
            tempStorage[j++] = theArray[upperPointer++];
        }
        //replace the range [lowerBound,upperBound] in theArray with
        //the range [0,n-1] just created in tempStorage
        for(j=0; j<n; ++j) {
            theArray[lowerBound+j] = tempStorage[j];
        }

    }



    void mergeSort(int[] tempStorage, int lower, int upper) {
        if(lower==upper){
            return;
        }
        else {
            int mid = (lower+upper)/2;
            mergeSort(tempStorage,lower,mid);  //sort left half
            mergeSort(tempStorage,mid+1, upper); //sort right half
            merge(tempStorage,lower,mid+1,upper); //merge them
        }
    }

    void mergeSortPlus(int[] tempStorage, int lower, int upper) {
        if(lower==upper){
            return;
        }else if(upper-lower <= 20){
            insertionSort(tempStorage);
        }else {
            int mid = (lower+upper)/2;
            mergeSort(tempStorage,lower,mid);  //sort left half
            mergeSort(tempStorage,mid+1, upper); //sort right half
            merge(tempStorage,lower,mid+1,upper); //merge them
        }
    }

    private int[] insertionSort(int[] array) {

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


    //set up routines
    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        //ms.testMerge();
        ms.testMergeSort();
        ms.testMergeSortPlus();
    }
    public void testMerge() {

        //create an array whose left half is sorted and whose
        //right half is sorted
        loadArray();
        int n = theArray.length;
        int[] tempStorage = null;
        int half = n/2;
        tempStorage = new int[n];
        mergeSort(tempStorage,0,half);
        tempStorage = new int[n];
        mergeSort(tempStorage, (n/2)+1, n-1);

        //begin display -- start with left half sorted, right half sorted
        System.out.println();
        System.out.println("an array with left half sorted and right half sorted:");
        displayArray(theArray);
        System.out.println();
        System.out.println("merging the two halves...");

        //call the merge method and display results
        tempStorage = new int[n];
        merge(tempStorage,0,half+1,n-1);
        displayArray(theArray);
    }
    public void testMergeSort(){
        loadArray();
        System.out.println("initial array:");
        displayArray(theArray);
        int n = theArray.length;
        int[] tempStorage = new int[n];

        long start = time();
        mergeSort(tempStorage,0,n-1);
        long finish = time();

        System.out.println();
        System.out.println("sorted array:");
        displayArray(theArray);

        System.out.println("\n\nThe consumed time : " + (finish - start)/100);
    }

    public void testMergeSortPlus(){
        loadArray();
        System.out.println("initial array:");
        displayArray(theArray);
        int n = theArray.length;
        int[] tempStorage = new int[n];

        long start = time();
        mergeSortPlus(tempStorage,0,n-1);
        long finish = time();

        System.out.println();
        System.out.println("sorted array:");
        displayArray(theArray);

        System.out.println("\n\nThe consumed time : " + (finish - start)/100);


    }

    static long time() {
        return System.nanoTime();
    }

    private void loadArray() {
        theArray = new int[ARRAY_SIZE];
        Random r = new Random();
        int next = 0;
        for(int i = 0; i < ARRAY_SIZE; ++i ){
            next = r.nextInt();
            next = Math.abs(next%MAX_VAL);
            //System.out.println("next int "+next);
            theArray[i]= Math.abs(next);
        }
    }

    private void displayArray(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

}
