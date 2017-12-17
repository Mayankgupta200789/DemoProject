package decision;

import tree.TreeNode;

/**
 * @Author Mayank Gupta
 * @Date 10/17/17
 */
public class MaximumSumBinaryTree {

    private int maxValue = Integer.MIN_VALUE;

    public static void main(String args[]) {

        MaximumSumBinaryTree maximumSumBinaryTree = new MaximumSumBinaryTree();

        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);


        System.out.println( maximumSumBinaryTree.maxPathSum(treeNode));

    }


    public int maxPathSum(TreeNode root) {

        maxPathDown(root);


        return maxValue;

    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left =  maxPathDown(node.left);
        int right = maxPathDown(node.right);
        maxValue = Math.max(maxValue, (left + right + node.val) > node.val ? left + right + node.val : node.val );
        return Math.max(left, right) + node.val;
    }
}
