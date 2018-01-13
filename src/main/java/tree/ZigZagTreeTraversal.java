package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Mayank Gupta
 * @Date 1/12/18
 */
public class ZigZagTreeTraversal {

		private Stack<TreeNode> stack1 = new Stack<>();

		private Stack<TreeNode> stack2 = new Stack<>();

		private List<List<Integer>> result = new LinkedList<>();

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

			if( root == null ) {
				return result;
			}

			stack1.push(root);

			int dir = 1;

			while( !stack1.isEmpty() || !stack2.isEmpty() ) {

				if( stack2.isEmpty()) {

					List<Integer> tempOutput = new LinkedList<>();
					while( !stack1.isEmpty()) {

						addNode(stack1, stack2,tempOutput,dir);
					}

					result.add(tempOutput);
					dir = -1;
				} else if ( stack1.isEmpty()) {

					List<Integer> tempOutput = new LinkedList<>();
					while( !stack2.isEmpty() ) {

						addNode(stack2, stack1,tempOutput,dir);

					}

					result.add(tempOutput);
					dir = 1;
				}
			}

			return result;
		}

		private void addNode(Stack<TreeNode> s1,Stack<TreeNode> s2,List<Integer> tempOutput, int dir) {

			TreeNode output = s1.pop();


			tempOutput.add(output.val);


			if( dir == 1 )  {

				if( output.left != null ) s2.push(output.left);
				if( output.right != null ) s2.push(output.right);

			}

			if( dir == -1 ) {

				if( output.right != null ) s2.push(output.right);
				if( output.left != null )   s2.push(output.left);
			}
		}

}
