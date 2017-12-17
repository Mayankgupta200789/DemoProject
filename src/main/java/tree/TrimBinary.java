package tree;

/**
 * @Author Mayank Gupta
 * @Date 11/5/17
 */
public class TrimBinary {

    public static void main(String args[]) {

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(4);
        tree.left.right = new TreeNode(2);
        tree.left.right.left = new TreeNode(1);

        TrimBinary trimBinary = new TrimBinary();
        trimBinary.trimBST(tree,1,2);

    }


    public TreeNode trimBST(TreeNode root, int L, int R) {

        if( root == null ) return null;

        if( root.val < L ) return trimBST(root.right,L,R);

        if( root.val > R ) return trimBST(root.left,L,R);

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);

        return root;
    }

}
