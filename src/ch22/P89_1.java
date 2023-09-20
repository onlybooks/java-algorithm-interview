package ch22;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P89_1 {
    public int majorityElement(int[] nums) {
        // 엘리먼트 개수 계산
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : nums) {
            countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
        }
        // 내림차순 정렬을 저장할 맵은 입력 순서가 유지되는 LinkedHashMap으로 선언
        Map<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        // countsMap을 내림차순으로 정렬해 reverseSortedMap으로 저장
        countsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        // 첫 번째 항목 추출
        Map.Entry<Integer, Integer> entry = reverseSortedMap.entrySet().iterator().next();
        // 과반수를 넘을 경우 정답으로 리턴
        if (entry.getValue() > nums.length / 2)
            return entry.getKey();
        // 항상 정답이 있는 문제이기 때문에 앞에서 처리되지만, 자바에서 리턴이 없으면 경고가 발생하므로 처리
        return -1;
    }
}
