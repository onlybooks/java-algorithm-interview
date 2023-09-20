package ch14

import datatype.TreeNode

class P50_6 {
    fun invertTree(root: TreeNode?): TreeNode? {
        // 빈 노드가 아닐 때 처리
        if (root != null) {
            // 왼쪽/오른쪽 자식 노드 스왑
            root.left = root.right.also { root.right = root.left }

            invertTree(root.left)  // 왼쪽 자식 노드 DFS
            invertTree(root.right) // 오른쪽 자식 노드 DFS
        }
        return root
    }
}