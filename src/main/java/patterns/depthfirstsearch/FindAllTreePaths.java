package patterns.depthfirstsearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Time complexity : O(N2),
 * where N is the total number of nodes in a tree.
 * Space com
 *
 *
 * There can't be more than (N+1)/2 leaves in a binary tree
 * The maximum number of elements in allPaths will be O(N+1/2)
 *
 * The depth of balanced binary tree, each leaf node will
 * be at maximum depth.
 *
 * Thus, for each depth , we will be doing this process multiple time
 * thus, it becomes O(N+1/2)* O(N) = O(N.logN)
 * Similar problems
 *
 * Similar Problems#
 * Problem 1: Given a binary tree, return all root-to-leaf paths.
 *
 * Solution: We can follow a similar approach. We just need to remove the “check for the path sum.”
 *
 * Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.
 *
 * Solution: We need to find the path with the maximum sum. As we traverse all paths, we can keep track of the path with the maximum sum.
 *
 */

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<Integer>();
        doFindPath(root,sum,currentPath,allPaths);
        return allPaths;
    }

    public static void doFindPath(TreeNode root, int sum, List<Integer> currentPath,
                                  List<List<Integer>> allPaths  ) {

        if(root == null ) return;

        currentPath.add(root.val);

        if(root.val == sum && root.left == null && root.right == null ) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            doFindPath(root.left, sum - root.val, currentPath,allPaths);
            doFindPath(root.right, sum - root.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
