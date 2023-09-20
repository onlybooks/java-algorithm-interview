package datatype;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode constructFromArray(Integer[] vals, int k) {
        if (k >= vals.length || vals[k] == null) {
            return null;
        }

        TreeNode root = new TreeNode(vals[k]);
        int leftIndex = 2 * k + 1;
        root.left = constructFromArray(vals, leftIndex);

        int rightIndex = 2 * k + 2;
        root.right = constructFromArray(vals, rightIndex);

        return root;
    }

    public TreeNode(Integer[] vals) {
        if (vals.length == 0) {
            left = null;
            right = null;
        }

        val = vals[0];
        left = constructFromArray(vals, 1);
        right = constructFromArray(vals, 2);
    }

    @Override
    public String toString() {
        return "" + val;
    }

    void print_r(TreeNode node, int level, StringBuilder sb) {
        if (node != null) {
            print_r(node.right, level + 1, sb);
            sb.append("\t".repeat(Math.max(0, level)));
            sb.append(node.val);
            sb.append("\n");
            print_r(node.left, level + 1, sb);
        }
    }
    
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        print_r(this, 0, sb);
        return sb.toString();
    }
}