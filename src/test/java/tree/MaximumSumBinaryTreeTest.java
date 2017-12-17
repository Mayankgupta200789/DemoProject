package tree;

import org.junit.Before;
import org.junit.Test;


/**
 * @Author Mayank Gupta
 * @Date 10/13/17
 */
public class MaximumSumBinaryTreeTest {

    private MaximumSumBinaryTree maximumSumBinaryTree;

    @Before
    public void setUp() throws Exception {

        maximumSumBinaryTree = new MaximumSumBinaryTree();
    }

    @Test
    public void maxPathSum() throws Exception {

        MaximumSumBinaryTree.TreeNode treeNode = new MaximumSumBinaryTree.TreeNode(2);
        treeNode.left = new MaximumSumBinaryTree.TreeNode(-1);
//        treeNode.right = new MaximumSumBinaryTree.TreeNode(3);

        maximumSumBinaryTree.maxPathSum(treeNode);
    }

}