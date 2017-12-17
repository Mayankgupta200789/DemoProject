package tree;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 10/7/17
 */
public class MinimumDifferenceInBST {

    public static void main(String args[]) {

        TreeNode treeNode = new TreeNode(543);
        treeNode.left =  new TreeNode(384);
        treeNode.left.right = new TreeNode(445);
        treeNode.right = new TreeNode(652);
        treeNode.right.right = new TreeNode(699);

        MinimumDifferenceInBST minimumDifferenceInBST = new MinimumDifferenceInBST();

        minimumDifferenceInBST.getMinimumDifference(treeNode);

    }


    public int getMinimumDifference(TreeNode root) {

        int min = Integer.MAX_VALUE;

        if( root == null ) {
            return min;
        }



        if( root.left == null && root.right == null ) {
            return root.val;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new PriorityQueue<>();


        queue.add(root);

        while( !queue.isEmpty() ) {

            TreeNode node = queue.remove();
            queue1.add(node.val);

            if( node.left != null ) queue.add(node.left);
            if( node.right != null ) queue.add(node.right);
        }


        while ( !queue1.isEmpty()) {
            Integer v1 = queue1.remove();

            if( queue1.isEmpty()) break;
            Integer v2 = queue1.peek();
            if( min > v2 - v1) {
                min = v2 - v1;
            }
        }

        return min;


    }


}
