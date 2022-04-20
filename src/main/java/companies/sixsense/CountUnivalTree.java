package companies.sixsense;

import tree.TreeNode;

import java.util.*;

public class CountUnivalTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);

        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(5);

        new CountUnivalTree().countUnivalSubtrees(treeNode);
    }

    public int countUnivalSubtrees(TreeNode root) {

        if(root == null ) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Boolean> uniValStatusMap = new HashMap<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if(isUnival(node,uniValStatusMap)) count++;

            if(node.left != null ) queue.add(node.left);
            if(node.right != null ) queue.add(node.right);
        }
        return count;

    }

    public boolean isUnival(TreeNode root, Map<TreeNode,Boolean> uniValStatusMap ) {

        if(root == null ) {
            return true;
        }if(uniValStatusMap.get(root) != null ) {
            return uniValStatusMap.get(root);
        } else if( root.left == null
                && root.right == null) {
            uniValStatusMap.put(root,true);
            return true;
        }

       TreeNode left = root.left;
       TreeNode right = root.right;

       if(left != null && left.val != root.val ) {
           uniValStatusMap.put(root,false);
           return false;
       }
       if( right != null && right.val != root.val ) {
           uniValStatusMap.put(root,false);
           return false;
       }
       if(isUnival(left,uniValStatusMap) && isUnival(right,uniValStatusMap)) {
           uniValStatusMap.put(root,true);
           return true;
       }

        uniValStatusMap.put(root,false);
       return false;

    }
}
