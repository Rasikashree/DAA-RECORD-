1.QUESTION: The Trie (Prefix Tree) data structure to efficiently insert, search, and check prefix matching of strings using node-based representation.

AIM: 
To implement a Trie (Prefix Tree) data structure to efficiently insert, search, and check prefix matching of strings using node-based representation.

ALGORITHM:
Step 1: Define a TrieNode class with an array of children (size 26 for lowercase letters) and a boolean isEndOfWord.
Step 2: Initialize the root node in the Trie constructor.
Step 3: In the insert() method, iterate through characters of the word, creating child nodes if they don’t exist.
Step 4: In the search() method, traverse the Trie using characters of the word. Return false if any node is missing; else return true if the last node is isEndOfWord = true.
Step 5: In the startsWith() method, similarly traverse using the prefix characters and return true if traversal is successful.

CODING:
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                return false;
            node = node.children[i];
        }
        return node.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                return false;
            node = node.children[i];
        }
        return true;
    }
}

INPUT:
Operations: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
Arguments : [ [], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"] ]

OUTPUT:
[null, null, true, false, true, null, true]


