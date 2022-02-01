package patterns.depthfirstsearch;

import tree.TreeNode;

/**
 *
 * /**
 *  * https://www.educative.io/courses/grokking-the-coding-interview/m280XNlPOkn
 *  *
 *  * Time complexity : O(N)
 *  * Space complexity : O(N)
 *  *
 *  *
 */
class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        int num = 0;
        for(int i = 0 ; i < sequence.length; i++ ) {

            num = num*10 + sequence[i];

        }
        return doFindPath(root,0,num);
    }

    public static boolean doFindPath(TreeNode root, int pathSum, int output ) {

        if(root == null ) return false;

        pathSum = 10 * pathSum + root.val;

        if(root.left == null && root.right == null && pathSum == output) {
            return true;
        }

        return doFindPath(root.left,pathSum,output) || doFindPath(root.right,pathSum,output);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
