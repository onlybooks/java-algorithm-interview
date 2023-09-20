package ch17;

import java.util.Arrays;

public class InsertionSortExample {
    static int[] Insertionsort(int[] A) {
        int i = 1;
        while (i < A.length) {
            int j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(Insertionsort(A)));
    }
}
