package ch06;

import java.util.ArrayList;
import java.util.List;

public class CallByValueExample {
    private static void modify(List<Integer> p) {
        p.add(7);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(6);
        // 아래의 결과로는 당연히 [5, 6]이 출력된다.
        System.out.println(a);
        // a를 파라미터로 전달받아 엘리먼트 추가
        CallByValueExample.modify(a);
        // 다시 결과를 출력해보면 [5, 6, 7]이 출력된다.
        System.out.println(a);
    }
}
