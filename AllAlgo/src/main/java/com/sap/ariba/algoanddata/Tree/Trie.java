package com.sap.ariba.algoanddata.Tree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    static TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    private void insert(String words) {
         TrieNode current = root;
        if (current != null) {
            for (Character chars : words.toCharArray()) {
                if (current.getChildren() != null) {
                    TrieNode node = current.getChildren().get(chars);
                    if (node == null || !node.isEndOfWord()) {
                        current.getChildren().put(chars, new TrieNode());
                    }
                    current = current.getChildren().get(chars);
                }
            }
            current.setEndOfWord(true);
        }
    }

    private static boolean searchTrie(String word) {
        TrieNode current = root;

        for (Character c : word.toCharArray()) {
            TrieNode node = current.getChildren().get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(root));
        System.out.printf("Search Found for the word :: %s%n", searchTrie("is"));
    }
}


class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    private boolean endOfWord = false;


    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", endOfWord=" + endOfWord +
                '}';
    }
}