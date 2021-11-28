package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {

    public static int findDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null ) queue.add(root);

        int depth = 1;

        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++ ) {

                TreeNode node = queue.remove();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if(left != null ) queue.add(left);
                if(right != null ) queue.add(right);

                if(left == null && right == null ) return depth;

            }
            depth++;
        }


        return depth;
    }

}
