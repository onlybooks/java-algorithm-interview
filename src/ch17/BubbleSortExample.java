package ch17;

import java.util.Arrays;

public class BubbleSortExample {
    static int[] Bubblesort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(Bubblesort(A)));
    }
}
