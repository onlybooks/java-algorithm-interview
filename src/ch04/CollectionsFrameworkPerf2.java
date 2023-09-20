package ch04;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFrameworkPerf2 {
    public static void main(String[] args) {
        // ArrayList<Integer> 1억 개 크기 지정
        long startTime = System.currentTimeMillis();
        List<Integer> fixedListElements = new ArrayList<>(100000000);
        for (int i = 0; i < 100000000 - 1; i++)
            fixedListElements.add(1);
        fixedListElements.add(2);
        System.out.printf("ArrayList<Integer> 크기 지정, 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);
    }
}
