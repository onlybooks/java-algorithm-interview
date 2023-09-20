package ch14;

import datatype.TreeNode;

public class P58_1 {
    // 이전 노드의 값, 가장 작은 수로 설정
    int prev = Integer.MIN_VALUE + 100000;
    // 노드 간 차이 최솟값, 가장 큰 수로 설정
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        // 왼쪽 자식 노드 맨 아래까지 탐색
        if (root.left != null) minDiffInBST(root.left);

        // 현재 노드 값과 이전 노드 값의 차이를 구하고 최솟값인지 확인
        minDiff = Math.min(minDiff, root.val - prev);
        // 현재 노드 값을 이전 노드 값으로 설정
        prev = root.val;

        // 오른쪽 자식 노드 재귀 탐색
        if (root.right != null) minDiffInBST(root.right);
        // 최솟값을 결과로 리턴
        return minDiff;
    }
}
