import java.util.Random;

/**
 * Created on 18.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class QuickSort {
    private QuickSort(){}

    /**
     * The method which takes integer Array to be sorted. Passes given array to overloaded <code>sort</code>
     * method with the first and the last indexes of the array.
     */
    public static void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    /**
     * Sort integer array with recursive call for left side of chosen pivot and right side of chosen pivot.
     * @param inputArray integer array
     * @param firstIndex index of the <b>first</b> element of chosen part of given array.
     * @param lastIndex index of the <b>last</b> element of chosen part of given array.
     */
    private static void sort(int[] inputArray, int firstIndex, int lastIndex){
        //termination condition of recursive call of the method. If firstIndex and lastIndex
        // are the same numbers.
        if(firstIndex == lastIndex)
            return;

        // Define the index of pivot element. THe choice of Random pivot gives better speed execution in average.
        int pivotIndex = new Random().nextInt(lastIndex - firstIndex) + firstIndex;

        // Place pivot in a separate variable;
        int pivot = inputArray[pivotIndex];

        // Swap pivot element and last element of the given array
        swap(inputArray, lastIndex, pivotIndex);

        // get the index of element where the pivot should be placed to.
        int leftPointer = getLeftPointer(inputArray, firstIndex, lastIndex, pivot);

        //Recursive call of the sort method for the left side of the array excluding current pivot
        sort(inputArray, firstIndex, leftPointer - 1);

        //Recursive call of the sort method for the right side of the array excluding current pivot
        sort(inputArray, firstIndex + 1, lastIndex);
    }

    /**
     * The method collects elements which are less than pivot at the left side relative to pointer And
     * elements which are greater than pivot at the right side relative to pointer.
     * @param inputArray initial array of ints.
     * @param firstIndex index of the first element of the part to be processed.
     * @param lastIndex index of the last element of the part to be processed.
     * @param pivot value of the pivot element of the given array.
     * @return the index of the place where the pivot was placed.
     */
    private static int getLeftPointer(int[] inputArray, int firstIndex, int lastIndex, int pivot) {
        // Left pointer which is the same as firstIndex of the given part of an array at start
        int leftPointer = firstIndex;
        // Right pointer which is the same as lastIndex of the given part of an array at start
        int rightPointer = lastIndex;

        // Main loop which runs till leftPointer equals rightPointer
        while (leftPointer < rightPointer){

            // find index of the element which is greater than pivot at the left side
            // increments leftPointer while current element is less than pivot
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            // find index of the element which is lower than pivot at the right side
            // decrements rightPointer while current element is greater than pivot
            while (inputArray[rightPointer] > pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            // swap elements at the defined places in input array
            swap(inputArray, leftPointer, rightPointer);
        }
        // When leftPointer and rightPointer are the same swap pivot element and element in the leftPointer place
        swap(inputArray, leftPointer, lastIndex);

        // return leftPointer index to be used in sort recursive calls for left and right sides of the array.
        return leftPointer;
    }

    /**
     * Swap the elements in the given array.
     * @param inputArray initial array of ints.
     * @param index1 index of the one element to be swapped.
     * @param index2 index of the other element to be swapped.
     */
    private static void swap(int[] inputArray, int index1, int index2){
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }
}
