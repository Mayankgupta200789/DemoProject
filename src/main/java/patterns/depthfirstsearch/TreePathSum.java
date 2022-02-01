package patterns.depthfirstsearch;

import tree.TreeNode;


//
//        The time complexity of the above algorithm is O(N)
//        , where ‘N’ is the total number of nodes in the tree.
//        This is due to the fact that we traverse each node once.
//
//        Space complexity#
//        The space complexity of the above algorithm will be O(N) in the worst case. This space will be used to store the recursion stack. The worst case
//        will happen when the given tree is a linked list (i.e., every node has only one child).
//


class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if ( root == null ) return false;


        return checkPathWithSum(root,sum);
    }

    public static boolean checkPathWithSum(TreeNode node, int sum ) {

        if(node == null ) return false;
        if( node.val == sum && node.left == null && node.right == null ) return true;

        return checkPathWithSum(node.left,sum - node.val ) || checkPathWithSum(node.right,sum - node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
