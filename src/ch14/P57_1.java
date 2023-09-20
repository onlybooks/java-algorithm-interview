package ch14;

import datatype.TreeNode;

public class P57_1 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 예외 처리
        if (root == null) return 0;

        // 결과 변수
        int result = 0;
        // 현재 노드의 값이 low와 high 사이에 있다면 결과에 추가
        if (low <= root.val && root.val <= high)
            result = root.val;
        // 자식 노드 재귀 DFS 진행
        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);

        return result;
    }
}
