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
        log.info("Before {}", toSort);
        log.info("After Insertion Sort {}", InsertionSort.sort(toSort));
    }
}
