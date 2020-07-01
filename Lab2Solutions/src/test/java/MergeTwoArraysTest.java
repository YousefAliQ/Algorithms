

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoArraysTest {

    MergeTwoArrays mergeTwoArrays;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mergeTwoArrays = new MergeTwoArrays();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @org.junit.jupiter.api.Test
    void merge() {
        int[] arr1 = new int[]{1, 4, 5, 8, 17};
        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
        int[] expectedResult = new int[]{1, 2, 4, 4, 5, 8, 8, 11, 13, 17, 21, 23, 25};

        int[] actualResult = mergeTwoArrays.merge(arr1, arr2);

        Assertions.assertEquals(Arrays.toString(actualResult), Arrays.toString(expectedResult));
    }

    @org.junit.jupiter.api.Test
    void mergeOneSide() {
        int[] arr1 = new int[0];
        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
        int[] expectedResult = new int[]{2, 4, 8, 11, 13, 21, 23, 25};

        int[] actualResult = mergeTwoArrays.merge(arr1, arr2);

        Assertions.assertEquals(Arrays.toString(actualResult), Arrays.toString(expectedResult));
    }

    @org.junit.jupiter.api.Test
    void mergeEmpty() {
        int[] arr1 = new int[0];
        int[] arr2 = new int[0];
        int[] expectedResult = new int[0];

        int[] actualResult = mergeTwoArrays.merge(arr1, arr2);

        Assertions.assertEquals(Arrays.toString(actualResult), Arrays.toString(expectedResult));
    }
}