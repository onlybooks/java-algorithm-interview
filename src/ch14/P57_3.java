package ch14;

import datatype.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P57_3 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 반복 구조 DFS 구현을 위한 스택 선언
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 스택에 루트부터 삽입
        stack.push(root);
        // 결과 변수 선언
        int result = 0;

        while (!stack.isEmpty()) {
            // 스택에서 노드 추출
            TreeNode node = stack.pop();

            // 노드 값이 low보다 크면 더 작아도 되므로 왼쪽 자식 노드 스택에 삽입
            if (node.val > low)
                if (node.left != null) stack.push(node.left);
            // 노드 값이 high보다 작으면 더 커도 되므로 오른쪽 자식 노드 스택에 삽입
            if (node.val < high)
                if (node.right != null) stack.push(node.right);
            // 노드 값이 low보다 크고 high보다 작으면 결과에 추가
            if (low <= node.val && node.val <= high)
                result += node.val;
        }
        return result;
    }
}
