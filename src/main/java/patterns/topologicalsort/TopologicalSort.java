package patterns.topologicalsort;

import java.util.*;


/**
 *
 * Time complexity : Each vertex will become a source only once and each edge will
 * be accessed and remove once.
 * Therefore, the time complexity of the above algorithm will be O(V + E), where 'V'
 * is the total number of vertices and 'E' is the total number of edges in the graph.
 *
 *
 */
class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for(int i = 0 ; i < edges.length;i++ ) {
            inDegree.put(edges[i][0],0);
            inDegree.put(edges[i][1],0);
            graph.put(edges[i][0],new ArrayList<>());
            graph.put(edges[i][1],new ArrayList<>());
        }


        for(int[] edge : edges ) {

            int parent = edge[0];
            int child = edge[1];

            inDegree.put(child,inDegree.getOrDefault(child,0) + 1);
            graph.get(parent).add(child);
        }

        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()) {

            if(entry.getValue() == 0 ) {
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {

            int input = queue.poll();

            List<Integer> kids = graph.get(input);
            result.add(input);

            for(Integer kid : kids ) {

                inDegree.put(kid, inDegree.getOrDefault(kid,0) - 1);

                if(inDegree.get(kid) == 0 ) {
                    queue.add(kid);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}