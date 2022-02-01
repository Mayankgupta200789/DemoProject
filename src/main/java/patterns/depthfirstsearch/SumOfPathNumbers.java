package patterns.depthfirstsearch;

import tree.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/
 *
 * Time complexity : O(N)
 * Space complexity : O(N)
 *
 */

public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root) {

        return doFindSum(root,0);
    }

    public static int doFindSum(TreeNode root, int pathSum ) {

        if(root == null ) return 0;

        pathSum = 10 * pathSum + root.val;

        if(root.left == null && root.right == null ) return pathSum;


        return doFindSum(root.left, pathSum) + doFindSum(root.right,pathSum);

    }
}
