package tree;

public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {

        if(root == null ) return 0;

        return getMaxDiff(root,root.val,root.val);

    }

    private int getMaxDiff(TreeNode root, int min, int max ) {


        // This is something that was missing.
        // For trees, look for the output of the base case.
        // Get the output for left and right
        // Then decide what needs to be done for left and right.
        // In this scenario, calculate the absolute diff of one node
        // take left and right and then whichever is max should be returned.
        if( root == null ) return Math.abs(max - min);

        if(root.val > max ) max = root.val;

        if(root.val < min ) min = root.val;

        int left = getMaxDiff(root.left,min,max);
        int right = getMaxDiff(root.right,min,max);

        return Math.max(left,right);

    }
}
