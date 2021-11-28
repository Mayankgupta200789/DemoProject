package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null ) queue.add(root);
        boolean keyFound = false;

        while(!queue.isEmpty()) {

            int nodesInLevel = queue.size();
            for(int i = 0 ; i < nodesInLevel; i++ ) {

                TreeNode node = queue.remove();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if( keyFound ) return node;
                if( node.val == key ) keyFound = true;

                if( node.left != null ) queue.add(left);
                if( node.right != null ) queue.add(right);
            }
        }
        return null;
    }
}
