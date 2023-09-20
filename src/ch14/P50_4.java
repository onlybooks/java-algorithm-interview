package ch14;

import datatype.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P50_4 {
    public TreeNode invertTree(TreeNode root) {
        // 예외 처리
        if (root == null)
            return null;

        // 반복 DFS 처리를 위한 스택 선언
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 스택에 루트부터 삽입
        stack.push(root);

        // 스택이 모두 비워질 때까지 반복
        while (!stack.isEmpty()) {
            // 스택에서 노드 추출
            TreeNode node = stack.pop();
            // 왼쪽/오른쪽 자식 노드 스왑
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 왼쪽 자식노드가 널이 아니면 스택 삽입
            if (node.left != null)
                stack.push(node.left);
            // 오른쪽 자식노드가 널이 아니면 스택 삽입
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }
}
