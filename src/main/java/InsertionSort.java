/**
 * Created on 13.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class InsertionSort {
    private InsertionSort() {
    }
    public static int[] sort(int[] toSort){
        for (int i = 1; i < toSort.length; i++) {
            int current = toSort[i];
            int j = i-1;
            while(j >= 0 && toSort[j] > current){
                toSort[j+1] = toSort[j];
                j--;
            }
            toSort[j + 1] = current;
        }
        return toSort;
    }
}
