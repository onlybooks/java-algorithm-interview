package ch12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P40_1 {
    public void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        // 모든 탐색 경로를 매번 결과에 추가
        results.add(new ArrayList<>(path));
        // 자기 자신보다 큰 숫자를 DFS 진행
        for (int i = index; i < nums.length; i++) {
            // path에 현재 엘리먼트 추가
            path.add(nums[i]);
            // 재귀 DFS
            dfs(results, nums, i + 1, path);
            // 돌아온 이후에는 현재 엘리먼트 삭제
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        // 결과 저장 리스트 선언
        List<List<Integer>> results = new ArrayList<>();
        // DFS 시작
        dfs(results, nums, 0, new ArrayDeque<>());

        return results;
    }
}
