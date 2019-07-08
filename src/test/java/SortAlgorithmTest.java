import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortAlgorithmTest {

    int[] sourceArray = new int[]{10, 20, 2, 3, 1, 6, 42, 378, 21, 433, 8};
    int[] expectArray = new int[]{1, 2, 3, 6, 8, 10, 20, 21, 42, 378, 433};


    @Test
    public void bubbleSortTest() {
        int[] tmpArray = SortAlgorithm.bubbleSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

    @Test
    public void quickSortTest() {
        int[] tmpArray = SortAlgorithm.quickSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

    @Test
    public void streamSortTest() {
        int[] tmpArray = SortAlgorithm.streamSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

    @Test
    public void bucketSortTest() {
        int[] tmpArray = SortAlgorithm.bubbleSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

}
