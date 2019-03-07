package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/7 11:19
 */
public class TrieNode {

    private char character;
    private String dirtyWord;
    private Map<Character, TrieNode> child;

    public TrieNode() {
        this.child = new HashMap<>();
    }

    public TrieNode(char character) {
        this.character = character;
        this.child = new HashMap<>();
    }

    public TrieNode insertNode(char character) {
        TrieNode childNode = this.child.get(character);
        if (childNode == null) {
            childNode = new TrieNode(character);
            this.child.put(character, childNode);
        }
        return childNode;
    }

    public TrieNode findNode(char character) {
        return this.child.get(character);
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getDirtyWord() {
        return dirtyWord;
    }

    public void setDirtyWord(String dirtyWord) {
        this.dirtyWord = dirtyWord;
    }
}
