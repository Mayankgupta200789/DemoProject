package tree;

/**
 * @Author Mayank Gupta
 * @Date 10/27/17
 */
public class SecondMinimumBinaryTree {


    public int findSecondMinimumValue(TreeNode root) {

        if( root == null ) return -1;

        if( root.left == null && root.right == null ) return -1;

        TreeNode result = findMinimum(root);

//        TreeSet treeSet = new TreeSet<Integer>(2);
        return result != null ? result.val : -1;

    }


    private TreeNode findMinimum(TreeNode root ) {

        if( root == null )  return null;

        if( root.left == null ) return null;

        if( root.left.left == null && root.val != root.left.val ) return root;

        if( root.left.left == null ) return null;

        return findMinimum(root.left);

    }
}
