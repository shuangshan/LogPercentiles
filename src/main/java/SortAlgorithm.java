
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author shuangshan
 * @create 2019-07-0711:08
 * @email 13690578@qq.com
 * @description The major sort algorithm for int. After test, 1. bubble sort need 27ms to finish the
 * test case 2. quick sort only need 1ms finish 11 int sort, 3. jdk8 stream sort need 14ms finish 11
 * int sort, so obviously quick sort is good choice
 */
public class SortAlgorithm {

    public SortAlgorithm() {

    }


    /**
     * bubble sort for int array, Average time complexity O(n*n), space complexity O(1)
     *
     * @Param {@link int[]}
     * @Return {@link int[]}
     **/
    public static int[] bubbleSort(int[] sourceArray) {
        // copy source array.
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // flag to identify sort complete.
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // when switch happened means sort still happening, otherwise means all data be sorted.
                    flag = false;
                }
            }
            if (flag) {
                //no array element switch means all data sorted.
                break;
            }
        }
        return arr;
    }

    /**
     * quick sort for int array, Average time complexity O(n log(n)), space complexity O(log n)
     *
     * @Param {@link int[]}
     * @Return {@link int[]}
     **/
    public static int[] quickSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSortRecursion(arr, 0, arr.length - 1);
    }

    private static int[] quickSortRecursion(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSortRecursion(arr, left, partitionIndex - 1);
            quickSortRecursion(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @Description use JDK8 stream sorted for testing
     * @Param {@link int[]}
     * @Return {@link int[]}
     **/
    public static int[] streamSort(int[] sourceArray) {
        IntStream intStream = Arrays.stream(sourceArray);
        int[] result = intStream.sorted().toArray();
        return result;
    }
}
