package tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAncestorDiffTest {

    @Test
    public void maxAncestorDiff() {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);

        root.left.left = new TreeNode(1);

        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);

        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);

        root.right.right = new TreeNode(14);

        root.right.right.left = new TreeNode(13);

        MaxAncestorDiff maxAncestorDiff = new MaxAncestorDiff();
        Assert.assertEquals(7,maxAncestorDiff.maxAncestorDiff(root));
        Assert.assertEquals(4,maxAncestorDiff.maxAncestorDiff(root.right));
        Assert.assertEquals(4,maxAncestorDiff.maxAncestorDiff(root.left));
        Assert.assertEquals(2,maxAncestorDiff.maxAncestorDiff(root.left.right));
        Assert.assertEquals(1,maxAncestorDiff.maxAncestorDiff(root.right.right));
    }
}