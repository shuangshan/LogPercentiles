package com.css.test;

import com.css.SortAlgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortAlgorithmTest {

    int[] sourceArray = new int[]{10, 20, 2, 3, 1, 6, 42, 378, 21, 433, 8};
    int[] expectArray = new int[]{1, 2, 3, 6, 8, 10, 20, 21, 42, 378, 433};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void bubbleSortTest() {
        int[] tmpArray = SortAlgorithm.bubbleSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

    @Test
    void quickSortTest() {
        int[] tmpArray = SortAlgorithm.quickSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }

    @Test
    void streamSortTest() {
        int[] tmpArray = SortAlgorithm.streamSort(sourceArray);
        assertArrayEquals(expectArray, tmpArray);
    }
}