package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {

    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if( root != null ) queue.add(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            double sum = 0;

            for(int i = 0;i < levelSize; i++ ) {

                TreeNode node = queue.remove();

                sum += node.val;

                TreeNode left = node.left;
                TreeNode right = node.right;

                if( left != null ) queue.add(left);
                if( right != null ) queue.add(right);

            }

            double output = sum / levelSize;

            result.add(output);

        }


        return result;
    }

}
