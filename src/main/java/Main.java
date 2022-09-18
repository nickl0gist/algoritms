import lombok.extern.slf4j.Slf4j;
/**
 * Created on 13.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        int[] toSort = {3, 2, 1, 4, 7, 8, 6};
        log.info("Before Insertion Sort {}", toSort);
        log.info("After Insertion Sort {}", InsertionSort.sort(toSort));

        toSort = new int[]{3, 2, 1, 4, 7, 8, 6};
        log.info("Before Merge Sort {}", toSort);
        MergeSort.mergeSort(toSort);
        log.info("After Merge Sort {}", toSort);

        toSort = new int[]{3, 2, 1, 4, 7, 8, 6};
        log.info("Before Quick Sort {}", toSort);
        QuickSort.sort(toSort);
        log.info("After Quick Sort {}", toSort);
    }
}
