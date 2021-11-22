package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ILevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> output = new LinkedList<>();

        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            for(int i = 0 ; i < levelSize; i++ ) {

                TreeNode node = queue.remove();
                output.add(node.val);
                if(node.left != null ) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
            }
            if(!output.isEmpty()) result.add(new ArrayList<>(output));
            output.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ILevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
