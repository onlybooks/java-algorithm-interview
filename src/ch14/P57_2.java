package ch14;

import datatype.TreeNode;

public class P57_2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 예외 처리
        if (root == null) return 0;

        // 노드 값이 high보다 크면 더 작아야 하므로 BST 왼쪽 노드 탐색
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        // 노드 값이 low보다 작으면 더 커야 하므로 BST 오른쪽 노드 탐색
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        // 여기까지 도달했다면 노드 값이 low와 high 범위 내에 있으므로, 모든 결과를 합산하여 리턴
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}