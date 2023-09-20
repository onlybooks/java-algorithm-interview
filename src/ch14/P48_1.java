package ch14;

import datatype.TreeNode;

public class P48_1 {
    // 가장 긴 값을 저장하는 변수
    int longest = 0;

    public int dfs(TreeNode node) {
        // 예외 처리
        if (node == null)
            return -1;
        // 왼쪽, 오른쪽의 각 리프 노드까지 재귀 DFS
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 가장 긴 경로 계산
        this.longest = Math.max(this.longest, left + right + 2);
        // 왼쪽/오른쪽 노드 중 큰 값에 +1 하여 리턴
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // 재귀 DFS 시작
        dfs(root);
        return this.longest;
    }
}