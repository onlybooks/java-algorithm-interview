package ch14;

import datatype.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P58_2 {
    public int minDiffInBST(TreeNode root) {
        // 이전 노드의 값, 가장 작은 수로 설정
        int prev = Integer.MIN_VALUE + 100000;
        // 노드 간 차이 최솟값, 가장 큰 수로 설정
        int minDiff = Integer.MAX_VALUE;

        // 반복 구조 DFS 구현을 위한 스택 선언
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 루트를 node 변수로 선언
        TreeNode node = root;

        // 스택이 비어있거나 node가 널이 될 때까지 반복
        while (!stack.isEmpty() || node != null) {
            // 왼쪽 자식 노드 맨 아래까지 스택에 삽입
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 스택에서 노드 추출
            node = stack.pop();

            // 현재 노드 값과 이전 노드 값의 차이를 구하고 최솟값인지 확인
            minDiff = Math.min(minDiff, node.val - prev);
            // 현재 노드 값을 이전 노드 값으로 설정
            prev = node.val;

            // 오른쪽 자식 노드를 node로 지정
            node = node.right;
        }
        // 최솟값을 결과로 리턴
        return minDiff;
    }
}
