package ch04;

public class JavaPerf {
    public static void main(String[] args) {
        long startTime;
        int index;

        // int[] 1억 개 삽입
        startTime = System.currentTimeMillis();
        int[] intElements = new int[100000000];
        for (int i = 0; i < 100000000 - 1; i++)
            intElements[i] = 1;
        intElements[100000000 - 1] = 2;
        System.out.printf("int[] 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // int[] 1억 개 중 찾기
        startTime = System.currentTimeMillis();
        index = 0;
        while (2 != intElements[index])
            index++;
        System.out.printf("int[] 1억 개 중 찾기: %s밀리초\n", System.currentTimeMillis() - startTime);

        // ---

        // Integer[] 1억 개 삽입
        startTime = System.currentTimeMillis();
        Integer[] integerElements = new Integer[100000000];
        for (int i = 0; i < 100000000 - 1; i++)
            integerElements[i] = 1;
        integerElements[100000000 - 1] = 2;
        System.out.printf("Integer[] 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // Integer[] 1억 개 중 찾기
        startTime = System.currentTimeMillis();
        index = 0;
        while (2 != integerElements[index])
            index++;
        System.out.printf("Integer[] 1억 개 중 찾기: %s밀리초\n", System.currentTimeMillis() - startTime);
    }
}
