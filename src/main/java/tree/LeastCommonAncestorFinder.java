package tree;

/**
 * @Author Mayank Gupta
 * @Date 11/11/16
 */
public class LeastCommonAncestorFinder {


    public BinarySearchTree find (BinarySearchTree node,BinarySearchTree first, BinarySearchTree second ) {


        if( node == null ) {
            return null;
        }

        if( first.getValue() > node.getValue() && second.getValue() > node.getValue() ){
            return find(node.getRight(),first,second);
        }

        if( first.getValue() < node.getValue() && second.getValue() < node.getValue() ) {
            return find(node.getLeft(),first, second );
        }

        return node;

    }








}
