package ch04;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFrameworkPerf1 {
    public static void main(String[] args) {
        long startTime;

        // ArrayList<Integer> 1억 개 삽입
        startTime = System.currentTimeMillis();
        List<Integer> listElements = new ArrayList<>();
        for (int i = 0; i < 100000000 - 1; i++)
            listElements.add(1);
        listElements.add(2);
        System.out.printf("ArrayList<Integer> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // ArrayList<Integer> 1억 개 중 찾기
        startTime = System.currentTimeMillis();
        listElements.contains(2);
        System.out.printf("ArrayList<Integer> 1억 개 중 찾기: %s밀리초\n", System.currentTimeMillis() - startTime);
    }
}
