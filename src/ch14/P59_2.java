package ch14;

import datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P59_2 {
    public TreeNode dfs(List<Integer> preOrder, List<Integer> inOrder) {
        // 예외 처리
        if (inOrder.isEmpty()) return null;

        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스인지 추출
        int inIndex = inOrder.indexOf(preOrder.get(0));
        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정
        TreeNode node = new TreeNode(inOrder.get(inIndex));

        // 왼쪽 자식 노드부터 진행
        node.left = dfs(preOrder.subList(1, inIndex + 1), inOrder.subList(0, inIndex));
        // 오른쪽 자식 노드 진행
        node.right = dfs(preOrder.subList(inIndex + 1, preOrder.size()), inOrder.subList(inIndex + 1, inOrder.size()));

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 원시형을 참조형으로 처리하기 위해 변수 선언
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();

        // 정수형 배열을 리스트에 삽입하여 변환
        for (int pre : preorder)
            preOrder.add(pre);
        for (int in : inorder)
            inOrder.add(in);

        // 재귀 DFS 진행, 리스트로 처리하면 파라미터가 간결해진다.
        return dfs(preOrder, inOrder);
    }
}
