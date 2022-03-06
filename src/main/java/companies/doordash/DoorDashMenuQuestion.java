package companies.doordash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorDashMenuQuestion {

    class Node {
        String key;
        int value;
        Boolean active;
        List<Node> children;

        public Node(String key, int value, Boolean active) {
            this.key = key;
            this.value = value;
            this.active = active;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node)o;
            return node.key == this.key && node.value == this.value
                        && node.active.equals(active);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + value;
            result = 31 * result + (active != null ? active.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            return result;
        }

    }


    public int getModifiedNodes(Node oldMenu, Node newMenu ) {

        if(oldMenu == null && newMenu == null )return  0;
        int count = 0;
        if(oldMenu == null || !oldMenu.equals(newMenu)) {
            count++;
        }

        Map<String, Node> children1 = getChildNodes(oldMenu);
        Map<String, Node> children2 = getChildNodes(oldMenu);

        for(Map.Entry<String,Node> entry : children1.entrySet() ) {
            count  += getModifiedNodes(children1.get(entry.getKey()),children2.get(entry.getKey()));
        }

        for(Map.Entry<String,Node> entry : children2.entrySet() ) {
            if(!children1.containsKey(entry.getKey())) {
                count += getModifiedNodes(children1.get(entry.getKey()), children2.get(entry.getKey()));
            }
        }

        return count;
    }

    public Map<String,Node> getChildNodes(Node node ) {

        Map<String,Node> nodeMap = new HashMap<>();

        if(node == null ) return null;

        for(Node input : node.children ) {
            nodeMap.put(input.key, node);
        }

        return nodeMap;
    }

}
