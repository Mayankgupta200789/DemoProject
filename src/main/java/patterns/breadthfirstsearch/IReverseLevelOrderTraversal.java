package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
// Time complexity - O(n)
// Space complexity - O(n)

// Trick was to store always at 0th index
// This is a test commit
public class IReverseLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if( root == null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> output = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++ ) {

                TreeNode node = queue.remove();
                if(node != null ) output.add(node.val);
                if(node != null && node.left != null ) queue.add(node.left);
                if(node != null && node.right != null ) queue.add(node.right);
            }

            //*************************************************
            //THIS IS REALLY IMPORTANT. THERE IS NO NEED TO USE STACK HERE
            result.add(0,new ArrayList<>(output));
            //*************************************************
            output.clear();
        }

        return result;

    }
}
