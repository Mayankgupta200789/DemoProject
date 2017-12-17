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
            if(!node.nodes.containsKey(input.charAt(i)) ) {
                TrieNode newTrie = new TrieNode();
                node.nodes.put(input.charAt(i), newTrie);
                node = newTrie;
            } else {
                TrieNode trieNode = node.nodes.get(input.charAt(i));
                node = trieNode;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String input) {

        TrieNode node = root;

        for(int i = 0; i < input.length(); i++) {

            if(!node.nodes.containsKey(input.charAt(i))) {
                return false;
            } else {
                node = node.nodes.get(input.charAt(i));
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

            if(!node.nodes.containsKey(input.charAt(i))) {
                return result;
            } else {
                node = node.nodes.get(input.charAt(i));
            }
        }

        prefixSearchWord(input,node.nodes,result);

        return result;
    }

    private void prefixSearchWord(String word,Map<Character,TrieNode> hashMap, List<String>  result) {

        for(Map.Entry<Character,TrieNode> nodeEntry : hashMap.entrySet() ) {
            if( nodeEntry.getValue().isEnd ) {
                result.add(word + nodeEntry.getKey());
            }
            if( !nodeEntry.getValue().nodes.isEmpty()){
                prefixSearchWord(word + nodeEntry.getKey(), nodeEntry.getValue().nodes,result);
            }
        }
    }



    class TrieNode {

        Map<Character,TrieNode> nodes;

        boolean isEnd;

        public TrieNode() {

            this.nodes = new HashMap<>();
        }

    }
}
