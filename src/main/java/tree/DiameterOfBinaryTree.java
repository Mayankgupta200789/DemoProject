package tree;

public class DiameterOfBinaryTree {

    private int max = 0;

    public int maxDepth(TreeNode root) {

        maxDepth(root);
        return 0;
    }

    private int doMaxDepth(TreeNode node) {

        if( node == null ) return 0;

        int left = doMaxDepth(node.left);
        int right = doMaxDepth(node.right);

        max = Math.max(max,left + right);

        return Math.max(left,right) + 1;


    }
}
