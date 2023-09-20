package ch14;

import datatype.TreeNode;

public class P51_1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 한쪽이 널이면 널이 아닌 노드를 리턴한다.
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        // 병합된 노드 생성
        TreeNode node = new TreeNode(root1.val + root2.val);
        // 병합된 노드의 자식 노드로 기존 노드 왼쪽 자식 노드 DFS 진행
        node.left = mergeTrees(root1.left, root2.left);
        // 병합된 노드의 자식 노드로 기존 노드 오른쪽 자식 노드 DFS 진행
        node.right = mergeTrees(root1.right, root2.right);
        // 병합된 노드 리턴
        return node;
    }
}
