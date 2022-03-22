package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTrieDataStructure {


    private CustomTrie root = new CustomTrie();

    public class CustomTrie  {

        private char input;
        private Map<Character, CustomTrie> nodes = new HashMap<>();
        private boolean isEndNode;

        public Map<Character, CustomTrie> getNodes() {
            return nodes;
        }

        public void setNodes(Map<Character, CustomTrie> nodes) {
            this.nodes = nodes;
        }
    }

    public void insert(String input ) {
        CustomTrie node = root;

        for(int i = 0 ; i < input.length();i++ ) {

            if(node.getNodes().containsKey(input.charAt(i))) {
                CustomTrie customTrie = node.getNodes().get(input.charAt(i));
                node =customTrie;
            }else {
                CustomTrie newTrie = new CustomTrie();
                node.getNodes().put(input.charAt(i), newTrie);
                node =newTrie;
            }


        }
        node.isEndNode = true;
    }

    public List<String> prefixSearch(String prefix) {

        // Iterate through the word and reach to that specific trieNode

        List<String> result = new ArrayList<>();
        CustomTrie node = root;


        for(int i = 0 ; i < prefix.length(); i++ ) {

            if(!node.getNodes().containsKey(prefix.charAt(i))) {
                return result;
            } else {
                node = node.getNodes().get(prefix.charAt(i));
            }
        }

        doPrefixSearch(prefix,node.getNodes(),result);
        return result;

    }

    public void doPrefixSearch(String input, Map<Character,CustomTrie>  nodes ,List<String> result){

        for(Map.Entry<Character,CustomTrie> entry : nodes.entrySet()) {
            if (entry.getValue().isEndNode) {
                result.add(input + entry.getKey());
            } else {
                doPrefixSearch(input + entry.getKey(), entry.getValue().getNodes(), result);
            }
        }
    }
}
