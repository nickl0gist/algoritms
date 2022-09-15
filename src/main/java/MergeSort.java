/**
 * Created on 15.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class MergeSort {
    private MergeSort() {}

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;
        // Termination condition that allows the function to exit without calling itself.
        // In case when input Array contains 1 element or it is empty.
        if (inputLength < 2){
            return;
        }
        // Go to next code if input Array size is bigger than 1.

        // Index of element in the middle of inout Array.
        int middleIndex = inputLength / 2;

         //Create empty array with size of middleIndex for left half of input Array.
        int[] leftHalf = new int[middleIndex];

        //Create empty array with size of [inputLength - middleIndex] for right half of input Array.
        int[] rightHalf = new int[inputLength - middleIndex];

        // iterate through input Array. If current index is less than middleIndex current element
        // has to be added to left Array, otherwise to right Array.
        for (int i = 0; i < inputLength; i++) {
            if(i < middleIndex){
                leftHalf[i] = inputArray[i];
            } else {
                rightHalf[i - middleIndex] = inputArray[i];
            }
        }

        //Recursive call on LeftArray and RightArray
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //Once leftHalf and rightHalf size equal to 1 or 0 call merge(...) method
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // r - index for rightHalf array
        // l - index for leftHalf array
        // i - index for merged  array
        int r = 0, l = 0, i = 0;

        //iterate through arrays
        while(l < leftSize && r < rightSize){
            // compare current element of leftHalf array to current element of rightArray
            if(leftHalf[l] <= rightHalf[r]){ // if element from leftHalf is less or equal to rightHalf element
                inputArray[i] = leftHalf[l]; // put lower element to result array
                l++;
            } else { // otherwise if element from rightHalf is less than leftHalf element
                inputArray[i] = rightHalf[r]; // put lower element to result array
                r++;
            }
            i++; // increment pointer for result array.
        }
        //Once any of leftArray or rightArray has been went through put tail of other array
        //into the end of result array.
        while(l <  leftSize){
            inputArray[i] = leftHalf[l];
            l++;
            i++;
        }
        while(r < rightSize){
            inputArray[i] = rightHalf[r];
            r++;
            i++;
        }
    }
}
