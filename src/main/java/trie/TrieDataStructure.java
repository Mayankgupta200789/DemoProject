package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Mayank Gupta
 * @Date 9/21/17
 */
public class TrieDataStructure {


    private TrieNode root = new TrieNode();


    public void insert(String input) {

        TrieNode node = root;

        for(int i = 0; i < input.length(); i++ ) {
            if(!node.getNodes().containsKey(input.charAt(i)) ) {
                TrieNode newTrie = new TrieNode();
                node.getNodes().put(input.charAt(i), newTrie);
                node = newTrie;
            } else {
                node = node.getNodes().get(input.charAt(i));
            }
        }
        node.isEnd = true;
    }

    public boolean search(String input) {

        TrieNode node = root;

        for(int i = 0; i < input.length(); i++) {

            if(!node.getNodes().containsKey(input.charAt(i))) {
                return false;
            } else {
                node = node.getNodes().get(input.charAt(i));
            }
        }

        if( node.isEnd ) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> prefixSearch(String input ) {

        TrieNode node = root;

        List<String> result = new LinkedList<>();

        for(int i = 0 ; i < input.length();i++ ) {

            if(!node.getNodes().containsKey(input.charAt(i))) {
                return result;
            } else {
                node = node.getNodes().get(input.charAt(i));
            }
        }

        prefixSearchWord(input, node.getNodes(),result);

        return result;
    }

    private void prefixSearchWord(String word,Map<Character,TrieNode> hashMap, List<String>  result) {

        for(Map.Entry<Character,TrieNode> nodeEntry : hashMap.entrySet() ) {
            if( nodeEntry.getValue().isEnd ) {
                result.add(word + nodeEntry.getKey());
            }
            if( !nodeEntry.getValue().getNodes().isEmpty()){
                prefixSearchWord(word + nodeEntry.getKey(), nodeEntry.getValue().getNodes(),result);
            }
        }
    }



    class TrieNode {

        private Map<Character,TrieNode> nodes;

        boolean isEnd;

        public TrieNode() {

            this.setNodes(new HashMap<>());
        }

        public Map<Character, TrieNode> getNodes() {
            return nodes;
        }

        public void setNodes(Map<Character, TrieNode> nodes) {
            this.nodes = nodes;
        }
    }
}
