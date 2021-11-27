package patterns.breadthfirstsearch;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
// Time complexity - O(n)
// Space complexity - O(n), for storing a maximum of N/2 nodes at any level in the queue.
class ZigZagTraversal {
        public static List<List<Integer>> traverse(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            // TODO: Write your code here

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean reverse = false;
            List<Integer> outputs = new ArrayList<>();

            while(!queue.isEmpty()) {

                int levelSize = queue.size();


                for(int i = 0 ; i < levelSize; i++ ) {

                    TreeNode node = queue.remove();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if(reverse) {
                        outputs.add(0,node.val);
                    } else {
                        outputs.add(node.val);
                    }

                    if(left != null ) queue.add(left);
                    if(right != null ) queue.add(right);

                }
                reverse = !reverse;
                result.add(new ArrayList<>(outputs));
                outputs.clear();
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
            root.right.left.left = new TreeNode(20);
            root.right.left.right = new TreeNode(17);
            List<List<Integer>> result = ZigZagTraversal.traverse(root);
            System.out.println("Zigzag traversal: " + result);
      }
 }


