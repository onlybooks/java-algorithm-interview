package ch09;

public class AutoBoxingPerf {
    public static void main(String[] args) {
        long startTime;

        // int 원시형 1억 번 계산
        startTime = System.currentTimeMillis();
        int sum1 = 0;
        for (int i = 0; i < 100000000; i++)
            sum1 += i;
        System.out.printf("int 원시형 1억 번 계산: %s밀리초\n", System.currentTimeMillis() - startTime);

        // ---

        // Integer 참조형 1억 번 계산
        startTime = System.currentTimeMillis();
        Integer sum2 = 0;
        for (int i = 0; i < 100000000; i++)
            sum2 += i;
        System.out.printf("Integer 참조형 1억 번 계산: %s밀리초\n", System.currentTimeMillis() - startTime);
    }
}
