package companies.microsoft.custom;

import concepts.HashEqual;

import java.util.*;

public class FriendFinder {


    class Person {

        private int id;
        private List<Integer> friends;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Integer> getFriends() {
            return friends;
        }

        public void setFriends(List<Integer> friends) {
            this.friends = friends;
        }
    }

    class PathNode {

        Person person;
        PathNode previous;

        public PathNode(Person person, PathNode previous){
            this.person = person;
            this.previous = previous;
        }


        public LinkedList<PathNode> collapse(boolean startFromRoot) {

            LinkedList<PathNode> path = new LinkedList<>();
            PathNode node = this;

            while(node != null ) {
                if (startFromRoot) path.addLast(node);
                else path.addFirst(node);
                node = node.previous;
            }
            return path;

        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public PathNode getPrevious() {
            return previous;
        }

        public void setPrevious(PathNode previous) {
            this.previous = previous;
        }
    }

    class BFSData {

        public Queue<PathNode> toVisit = new LinkedList<>();
        public Map<Integer,PathNode> visited = new HashMap<>();

        public BFSData(Person person ){
            PathNode pathNode = new PathNode(person, null);
            toVisit.add(pathNode);
            visited.put(person.getId(),pathNode);
        }

        public boolean isFinished() {
            return toVisit.isEmpty();
        }
    }


    Person searchLevel(BFSData primary, BFSData secondary, Map<Integer,Person> people) {

        int size = primary.toVisit.size();

        for(int i = 0 ; i < size; i++ ) {

            PathNode pathNode = primary.toVisit.poll();
            int primaryPersonId = pathNode.getPerson().getId();

            if(secondary.visited.containsKey(primaryPersonId)){
                return pathNode.getPerson();
            }

            List<Integer> friends = pathNode.getPerson().getFriends();

            for(int friend : friends ){

                if(primary.visited.containsKey(friend)){

                    PathNode previousPathNode = new PathNode(people.get(friend), pathNode);
                    primary.visited.put(friend,previousPathNode);
                    primary.toVisit.add(previousPathNode);
                }
            }
        }
        return null;
    }

    LinkedList<PathNode> mergePath(BFSData bfs1, BFSData bfs2, int connection ) {

        PathNode pathNode1 = bfs1.visited.get(connection);
        PathNode pathNode2 = bfs2.visited.get(connection);

        LinkedList<PathNode> pathOne = pathNode1.collapse(false);
        LinkedList<PathNode> pathTwo = pathNode2.collapse(true);

        pathTwo.removeFirst();
        pathOne.addAll(pathTwo);

        return pathOne;
    }

    public int bfs(int source,int destination, Map<Integer,Person>  personMap) {

        BFSData bfs1 = new BFSData(personMap.get(source));
        BFSData bfs2 = new BFSData(personMap.get(destination));

        Person collision = searchLevel(bfs1, bfs2, personMap);

        if(collision != null ) {
            mergePath(bfs1,bfs2,collision.getId()).size();
        }

        collision = searchLevel(bfs2, bfs1, personMap);

        if(collision != null ) {
            return mergePath(bfs2,bfs1,collision.getId()).size();
        }


    }
}
