package ch05;

import java.util.*;

public class CollectionsFrameworkPerf {
    public static void main(String[] args) {
        long startTime;

        // ArrayList<Integer> 1억 개 삽입
        startTime = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000000; i++)
            arrayList.add(1);
        System.out.printf("ArrayList<Integer> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // LinkedList<Integer> 1억 개 삽입
        startTime = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000000; i++)
            linkedList.add(1);
        System.out.printf("LinkedList<Integer> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // ---

        // ArrayList<Integer> 1000000번째 인덱스 100개 삭제
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
            arrayList.remove(1000000);
        System.out.printf("ArrayList<Integer> 1000000번째 인덱스 1백 개 삭제: %s밀리초\n", System.currentTimeMillis() - startTime);

        // LinkedList<Integer> 1000000번째 인덱스 100개 삭제
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
            linkedList.remove(1000000);
        System.out.printf("LinkedList<Integer> 1000000번째 인덱스 1백 개 삭제: %s밀리초\n", System.currentTimeMillis() - startTime);

        // --

        // ArrayDeque<Integer> 1억 개 삽입
        startTime = System.currentTimeMillis();
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 100000000; i++)
            arrayDeque.offer(1);
        System.out.printf("ArrayDeque<Integer> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // LinkedList<Integer> 1억 개 삽입
        startTime = System.currentTimeMillis();
        Deque<Integer> dequeLinkedList = new LinkedList<>();
        for (int i = 0; i < 100000000; i++)
            dequeLinkedList.offer(1);
        System.out.printf("LinkedList<Integer> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime);

        // ---

        // ArrayDeque<Integer> 10만 개 추출
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            arrayDeque.poll();
        System.out.printf("ArrayDeque<Integer> 10만 개 추출: %s밀리초\n", System.currentTimeMillis() - startTime);

        // LinkedList<Integer> 10만 개 추출
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            dequeLinkedList.poll();
        System.out.printf("LinkedList<Integer> 10만 개 추출: %s밀리초\n", System.currentTimeMillis() - startTime);
    }
}
