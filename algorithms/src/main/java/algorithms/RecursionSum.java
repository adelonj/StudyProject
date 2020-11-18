package algorithms;

import java.util.Arrays;

public class RecursionSum {
    public int sum(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        System.out.println(Arrays.toString(arr));
        int i = arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        return i;
    }
}
