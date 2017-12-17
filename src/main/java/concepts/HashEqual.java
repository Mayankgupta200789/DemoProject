package concepts;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 8/14/17
 */
public class HashEqual {

        public int[] equal(int[] A) {

            Map<Long,LinkedList> hashMap = new LinkedHashMap<>();


            for( int i = 0 ; i < A.length; i++ ) {

                for( int j = (i + 1 ); j < A.length; j++ ) {

                    long sum = A[i] + A[j];

                    Node n = new Node(i,j);

                    if( hashMap.containsKey(sum)) {

                        LinkedList<Node> queue = hashMap.get(sum);
                        queue.add(n);
                        Collections.sort(queue,new NodeComparator());
                    }else {
                        LinkedList<Node> queue = new LinkedList<>();
                        queue.add(n);
                        hashMap.put(sum,queue);
                    }
                }
            }

            int[] result = new int[4];
            List<Integer> list = new LinkedList<>();
            int i = 0;

            Set<Integer> hashSet = new HashSet<>();

            boolean flag = false;

            for(Map.Entry<Long,LinkedList> entry : hashMap.entrySet()) {


                if( entry.getValue().size() == 2 ) {

                    List<Node> queue = entry.getValue();

                    for(Node n : queue ) {

                        if( hashSet.contains(n.x) || hashSet.contains(n.y)) {
                            list.clear();
                            hashSet.clear();
                            break;
                        } else {
                            list.add(n.x);
                            list.add(n.y);
                            if( list.size() == 2 ){
                                flag = true;
                            }
                            hashSet.add(n.x);
                            hashSet.add(n.y);
                        }
                    }
                }
                if(flag) break;
            }

            for( Integer value : list) {
                result[i++] = value;
            }


            return result;


        }

        class NodeComparator implements Comparator<Node> {

            @Override
            public int compare(Node n1, Node n2 ) {
                if ( n1.x < n2.x ) {
                    return -1;
                } else if ( n1.x == n2.x && n1.y < n2.y ) {
                    return -1;
                } else if ( n1.x > n2.x ) {
                    return 1;
                }  else if ( n1.x == n2.x && n1.y > n2.y ) {
                    return 1;
                } else  {
                    return 0;
                }
            }

        }


        class Node {

            private int x;
            private int y;

            public Node(int x, int y ) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {

                int result = 0;

                result = 31  + x;
                result = 31 * result + y;
                return result;
            }

            @Override
            public boolean equals(Object o) {

                if( this == o ) return true;

                if( !(o instanceof Node)) return false;


                Node n = (Node)o;

                if( n.x != this.x ) return false;
                if( n.y != this.y ) return false;

                return true;
            }


        }
    }



