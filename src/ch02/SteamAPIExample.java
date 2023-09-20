package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SteamAPIExample {
    static class Member {
        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Member> members1 = new ArrayList<>();
        members1.add(new Member("카리나", 24));
        members1.add(new Member("윈터", 23));
        members1.add(new Member("지젤", 24));
        members1.add(new Member("닝닝", 22));

        // 스트림 API를 사용하지 않은 예전 방식
        List<String> chosenMembers = new ArrayList<>();
        // 나이가 24세인 멤버의 이름을 chosenMembers 리스트에 삽입
        for (Member member : members1) {
            if (member.age == 24)
                chosenMembers.add(member.name);
        }
        // chosenMembers 정렬
        Collections.sort(chosenMembers);
        // chosenMembers 출력
        for (String name : chosenMembers) {
            System.out.println(name);
        }

        // ---

        List<Member> members2 = new ArrayList<>();
        members2.add(new Member("카리나", 24));
        members2.add(new Member("윈터", 23));
        members2.add(new Member("지젤", 24));
        members2.add(new Member("닝닝", 22));

        members2.stream()                       // 스트림 API
                .filter(m -> m.age == 24)       // 24세 필터링
                .map(m -> m.name)               // 이름 매핑
                .sorted()                       // 정렬
                .collect(Collectors.toList())   // 리스트로 취합(아래 출력시 생략 가능)
                .forEach(System.out::println);  // 메소드 참조로 출력

        // ---

        // 숫자 리스트
        List<Double> numbers1 = Arrays.asList(49.1, 25.5, 9.9);
        // 람다 표현식
        numbers1.stream()                               // 스트림 API
                .map(n -> Math.round(n))                // 반올림 처리
                .forEach(n -> System.out.println(n));   // 순회하며 출력

        // ---

        // 숫자 리스트
        List<Double> numbers2 = Arrays.asList(49.1, 25.5, 9.9);
        // 메소드 참조
        numbers2.stream()                       // 스트림 API
                .map(Math::round)               // 반올림 처리
                .forEach(System.out::println);  // 순회하며 출력
    }
}
