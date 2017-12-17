package graph;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 8/10/17
 */
public class KnightProblem {

    private Set<Node> hashSet = new HashSet<>();


    public int knight(int A, int B, int C, int D, int E, int F) {

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        boolean queue1Flag = false;


        int level = -1;

        Node destNode = new Node(E,F);

        queue1.add(new Node(C,D));

        while(!queue1.isEmpty() || !queue2.isEmpty()) {

            if( queue2.isEmpty()) {


                while(!queue1.isEmpty()) {

                    if (!queue1Flag) {
                        queue1Flag = true;
                        level++;
                    }

                    Node n = queue1.remove();

                    if (!hashSet.contains(n)) {

                        if (n.equals(destNode)) {

                            return level;
                        }
                        addNodesToQueue(queue2, n, A, B);
                        hashSet.add(n);
                    }


                }
            } else if ( queue1.isEmpty()) {

                if( queue1Flag ) {
                    queue1Flag = false;
                    level++;
                }

                while(!queue2.isEmpty()) {
                    Node n = queue2.remove();

                    if (!hashSet.contains(n)) {

                        if (n.equals(destNode)) {

                            return level;
                        }
                        addNodesToQueue(queue1, n, A, B);
                        hashSet.add(n);
                    }



                }
            }
        }

        return -1;

    }

    private void addNodesToQueue(Queue<Node> queue,Node sourceNode,
                                 int sizeA, int sizeB) {

        int sourceX = sourceNode.getX();
        int destX = sourceNode.getY();

        if( doVerify(sourceX + 2,destX - 1, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX + 2, destX - 1))) {
            Node child = new Node(sourceX + 2, destX - 1);
            queue.add(child);

        }

        if( doVerify(sourceX + 2,destX + 1, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX + 2, destX + 1))) {
            Node child = new Node(sourceX + 2, destX + 1);
            queue.add(child);

        }


        if( doVerify(sourceX + 1,destX + 2, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX + 1, destX + 2))) {
            Node child = new Node(sourceX + 1, destX + 2);
            queue.add(child);

        }


        if( doVerify(sourceX + 1,destX - 2, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX + 1, destX - 2))) {
            Node child = new Node(sourceX + 1, destX - 2);
            queue.add(child);

        }

        if( doVerify(sourceX - 2,destX + 1, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX - 2, destX + 1))) {
            Node child = new Node(sourceX - 2, destX + 1);
            queue.add(child);

        }

        if( doVerify(sourceX - 2,destX - 1, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX - 2, destX - 1))) {
            Node child = new Node(sourceX - 2, destX - 1);
            queue.add(child);

        }

        if( doVerify(sourceX - 1,destX + 2, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX - 1, destX + 2))) {
            Node child = new Node(sourceX - 1, destX + 2);
            queue.add(child);

        }

        if( doVerify(sourceX - 1,destX - 2, sizeA,sizeB)
                && !hashSet.contains(new Node(sourceX - 1, destX - 2))) {
            Node child = new Node(sourceX - 1, destX - 2);
            queue.add(child);

        }


    }

    private boolean doVerify(int x , int y, int sizeA, int sizeB ) {

        if( (x > 0 && x <= (sizeA)) && y > 0 && y <= (sizeB)) {
            return true;
        }
        return false;
    }

    public class Node {

        private int x;
        private int y;


        public Node(int x, int y ) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if( this == o ) return true;

            if(!(o instanceof Node) ) return false;

            Node n = (Node)o;

            if( this.x != n.x) return false;
            if( this.y != n.y) return false;

            return true;
        }

        @Override
        public int hashCode() {

            int result = 0;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }

        public int getX(){
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
