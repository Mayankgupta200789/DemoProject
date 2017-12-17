package tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 8/23/17
 */
public class VerticalOrderBinaryTreeTest {

    private VerticalOrderBinaryTree verticalOrderBinaryTree;


    @Before
    public void setUp() throws Exception {

        verticalOrderBinaryTree = new VerticalOrderBinaryTree();
    }

    @Test
    public void verticalOrderTraversal() throws Exception {

        VerticalOrderBinaryTree.TreeNode treeNode1 = new VerticalOrderBinaryTree.TreeNode(6);
        VerticalOrderBinaryTree.TreeNode treeNode2 = new VerticalOrderBinaryTree.TreeNode(3);
        VerticalOrderBinaryTree.TreeNode treeNode3 = new VerticalOrderBinaryTree.TreeNode(7);
        VerticalOrderBinaryTree.TreeNode treeNode4 = new VerticalOrderBinaryTree.TreeNode(2);
        VerticalOrderBinaryTree.TreeNode treeNode5 = new VerticalOrderBinaryTree.TreeNode(5);
        VerticalOrderBinaryTree.TreeNode treeNode6 = new VerticalOrderBinaryTree.TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;


        ArrayList<ArrayList<Integer>> result = verticalOrderBinaryTree.verticalOrderTraversal(treeNode1);

        Assert.assertNotNull(result);


    }

}