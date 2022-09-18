import java.util.Random;

/**
 * Created on 18.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class QuickSort {
    private QuickSort(){}

    public static void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    private static void sort(int[] inputArray, int firstIndex, int lastIndex){
        if(firstIndex == lastIndex)
            return;

        int pivotIndex = new Random().nextInt(lastIndex - firstIndex) + firstIndex;
        int pivot = inputArray[pivotIndex];
        swap(inputArray, lastIndex, pivotIndex);

        int leftPointer = getLeftPointer(inputArray, firstIndex, lastIndex, pivot);
        sort(inputArray, firstIndex, leftPointer - 1);
        sort(inputArray, firstIndex + 1, lastIndex);
    }

    private static int getLeftPointer(int[] inputArray, int firstIndex, int lastIndex, int pivot) {
        int leftPointer = firstIndex;
        int rightPointer = lastIndex;
        while (leftPointer < rightPointer){
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (inputArray[rightPointer] > pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(inputArray, leftPointer, rightPointer);
        }
        swap(inputArray, leftPointer, lastIndex);
        return leftPointer;
    }

    private static void swap(int[] inputArray, int index1, int index2){
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }
}
