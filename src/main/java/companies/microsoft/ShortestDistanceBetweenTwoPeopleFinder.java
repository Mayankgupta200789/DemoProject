package companies.microsoft;

import java.util.*;

public class ShortestDistanceBetweenTwoPeopleFinder {

    class Person {

        private Integer id;
        private List<Integer> friends;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Integer> getFriends() {
            return friends;
        }

        public void setFriends(List<Integer> friends) {
            this.friends = friends;
        }
    }

    class BFSData {

        public Queue<PathNode> toVisit = new LinkedList<PathNode>();
        public HashMap<Integer,PathNode> visited = new HashMap<Integer,PathNode>();

        public BFSData(Person root ) {

            PathNode sourcePath = new PathNode(root,null);
            toVisit.add(sourcePath);
            visited.put(root.getId(),sourcePath);
        }

        public boolean isFinished() {
            return toVisit.isEmpty();
        }
    }

    class PathNode {
        private Person person = null;
        private PathNode prevousNode = null;

        public PathNode(Person p, PathNode previous) {
            this.person = p;
            this.prevousNode = previous;
        }

        public Person getPerson() {
            return person;
        }

        public LinkedList<Person> collapse(boolean startsWithRoot) {

            LinkedList<Person> path = new LinkedList<>();
            PathNode node = this;

            while(node != null ) {
                if(startsWithRoot)  path.addLast(node.person);
                else path.addFirst(node.person);
                node = node.prevousNode;
            }

            return path;
        }
    }
    /* Merge paths where searches met at the connection. */
    LinkedList<Person> mergePaths(BFSData bfs1,BFSData bfs2,int connection) {

        // end1 -> source, end2 -> dest
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);

        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true);

        pathTwo.removeFirst();// remove connection
        pathOne.addAll(pathTwo);// add second path

        return pathOne;
    }

    Person searchLevel(HashMap<Integer,Person> people, BFSData primary, BFSData secondary) {

        int count = primary.toVisit.size();

        for(int i = 0; i < count; i++ ) {


            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getId();

            if(secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            //Add friends to queue
            Person person = pathNode.getPerson();

            List<Integer> friends = person.getFriends();

            for(int friendId : friends) {

                if(!primary.visited.containsKey(friendId)) {

                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId,next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }

    LinkedList<Person> findPathBiBFS(HashMap<Integer,Person> people, int source, int destination) {

        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while(!sourceData.isFinished() && !destData.isFinished()) {

            Person collision = searchLevel(people, sourceData, destData);
            if(collision != null )
                return mergePaths(sourceData, destData, collision.getId());
            /* Search out from destination. */
            collision = searchLevel(people, destData, sourceData);
            if (collision != null)
                return mergePaths(sourceData, destData, collision.getId());
        }
        return null;
    }
}
