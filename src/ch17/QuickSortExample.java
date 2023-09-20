package ch17;

import java.util.Arrays;

public class QuickSortExample {
    static int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int left = lo;
        for (int right = lo; right < hi; right++) {
            if (A[right] < pivot) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
            }
        }
        int temp = A[left];
        A[left] = A[hi];
        A[hi] = temp;
        return left;
    }

    static int[] Quicksort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(A, lo, hi);
            Quicksort(A, lo, pivot - 1);
            Quicksort(A, pivot + 1, hi);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{38, 27, 43, 3, 9, 82, 10};
        Quicksort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }
}
