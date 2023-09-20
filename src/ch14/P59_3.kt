package ch14

import datatype.TreeNode

class P59_3 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // 예외 처리
        if (inorder.isEmpty()) return null

        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스인지 추출
        val inIndex = inorder.indexOf(preorder[0])
        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정
        val node = TreeNode(inorder[inIndex])

        // 왼쪽 자식 노드부터 진행
        node.left = buildTree(preorder.copyOfRange(1, inIndex + 1), inorder.copyOfRange(0, inIndex))
        // 오른쪽 자식 노드 진행
        node.right = buildTree(preorder.copyOfRange(inIndex + 1, preorder.size), inorder.copyOfRange(inIndex + 1, inorder.size))
        return node
    }
}