package ch14;

public class TreeTraversalsExample {
    static class TNode {
        char val;
        TNode left;
        TNode right;

        public TNode(char val) {
            this.val = val;
        }

        public TNode(char val, TNode left, TNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void preorder(TNode node) {
        if (node == null)
            return;
        System.out.printf("%c ", node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(TNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.printf("%c ", node.val);
        inorder(node.right);
    }

    public static void postorder(TNode node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.printf("%c ", node.val);
    }

    public static void main(String[] args) {
        // 그림 14-26 예제 트리 생성
        TNode root = new TNode('F',
                new TNode('B',
                        new TNode('A'),
                        new TNode('D',
                                new TNode('C'), new TNode('E'))
                ),
                new TNode('G',
                        null,
                        new TNode('I',
                                new TNode('H'), null))
        );

        // 전위 순회
        preorder(root);
        System.out.println();
        // 중위 순회
        inorder(root);
        System.out.println();
        // 후위 순회
        postorder(root);
        System.out.println();
    }
}
