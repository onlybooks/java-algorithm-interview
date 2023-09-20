package ch14;

import datatype.TreeNode;

public class P53_1 {
    public int dfs(TreeNode node) {
        // 예외 처리
        if (node == null)
            return 0;
        // 재귀 DFS로 왼쪽 리프 노드까지 탐색
        int left = dfs(node.left);
        // 재귀 DFS로 오른쪽 리프 노드까지 탐색
        int right = dfs(node.right);
        // 높이 균형이 아닌 경우 -1 리턴
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        // 왼쪽과 오른쪽 중 높은 노드 높이 +1 리턴
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // 높이 균형이 깨진 경우가 아니라면 true, -1이 리턴되어 높이 균형이 깨진 경우 false 리턴
        return dfs(root) != -1;
    }
}
