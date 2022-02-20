package companies.microsoft.february;

import tree.TreeNode;

public class CountGoodNodesBinaryTree {

    int c=0 ;
    public int goodNodes(TreeNode root) {
        trav(root , root.val) ;
        return c ;
    }
    public void trav(TreeNode root , int runningMax){
        if(root == null)return ;
        if(root.val >= runningMax){
            c++ ;
            runningMax = root.val ;
        }
        trav(root.left , runningMax) ;
        trav(root.right , runningMax) ;
    }
}
