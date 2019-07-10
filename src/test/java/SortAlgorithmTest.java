import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SortAlgorithmTest {

    int[] sourceArray = new int[]{10, 20, 2, 3, 1, 6, 42, 378, 21, 433, 8};
    int[] expectArray = new int[]{1, 2, 3, 6, 8, 10, 20, 21, 42, 378, 433};
    int[] sourceBigArray = new Random().ints(1000, 0, 10000000).toArray();

    @Test
    public void bubbleSortTest() {
        int[] tmpArray = SortAlgorithm.bubbleSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
        //test big array time cost
        tmpArray = SortAlgorithm.bubbleSort(sourceBigArray);
        //for test time cost, simplify assert
        assertTrue(tmpArray[0] <= tmpArray[1] && tmpArray[100] <= tmpArray[101]);
    }


    @Test
    public void quickSortTest() {
        int[] tmpArray = SortAlgorithm.quickSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
        tmpArray = SortAlgorithm.quickSort(sourceBigArray);
        //for test time cost, simplify assert
        assertTrue(tmpArray[0] <= tmpArray[1] && tmpArray[100] <= tmpArray[101]);
    }

    @Test
    public void streamSortTest() {
        int[] tmpArray = SortAlgorithm.streamSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
        tmpArray = SortAlgorithm.streamSort(sourceBigArray);
        //for test time cost, simplify assert
        assertTrue(tmpArray[0] <= tmpArray[1] && tmpArray[100] <= tmpArray[101]);
    }

    @Test
    public void bucketSortTest() {
        int[] tmpArray = SortAlgorithm.bucketSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
        tmpArray = SortAlgorithm.bucketSort(sourceBigArray);
        //for test time cost, simplify assert
        assertTrue(tmpArray[0] <= tmpArray[1] && tmpArray[100] <= tmpArray[101]);
    }

}
