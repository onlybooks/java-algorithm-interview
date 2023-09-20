package ch14;

import datatype.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P50_5 {
    public TreeNode invertTree(TreeNode root) {
        // 예외 처리
        if (root == null)
            return null;

        // 반복 BFS 처리를 위한 큐 선언
        Queue<TreeNode> queue = new LinkedList<>();
        // 큐에 루트부터 삽입
        queue.offer(root);

        // 큐가 모두 비워질 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드 추출
            TreeNode node = queue.poll();
            // 왼쪽/오른쪽 자식 노드 스왑
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 왼쪽 자식 노드가 널이 아니면 큐 삽입
            if (node.left != null)
                queue.offer(node.left);
            // 오른쪽 자식 노드가 널이 아니면 큐 삽입
            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }
}
