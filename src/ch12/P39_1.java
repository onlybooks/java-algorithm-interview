package ch12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P39_1 {
    public void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {
        // 0 보다 작다면 목푯값을 넘어섰으므로 리턴
        if (target < 0)
            return;
        // 0이면 목푯값에 도달했으므로 결과에 추가하고 리턴
        if (target == 0) {
            // 이전 경로를 저장해둔 path를 결과에 삽입
            results.add(new ArrayList<>(path));
            return;
        }
        // 자기 자신보다 큰 숫자를 DFS 진행
        for (int i = index; i < candidates.length; i++) {
            // path에 현재 엘리먼트 추가
            path.add(candidates[i]);
            // 재귀 DFS
            dfs(results, candidates, target - candidates[i], i, path);
            // 돌아온 이후에는 현재 엘리먼트 삭제
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 결과 저장 리스트 선언
        List<List<Integer>> results = new ArrayList<>();
        // DFS 시작
        dfs(results, candidates, target, 0, new ArrayDeque<>());

        return results;
    }
}