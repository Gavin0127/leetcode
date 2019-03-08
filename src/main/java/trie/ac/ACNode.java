package trie.ac;

import trie.TrieNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/8 12:02
 */
public class ACNode {

    private char character;

    private String dirtyWord;

    private Map<Character, ACNode> child;

    private ACNode fail;

    public ACNode() {
        this.child = new HashMap<>();
    }

    public ACNode(char character) {
        this.character = character;
        this.child = new HashMap<>();
    }

    public ACNode insertNode(char character) {
        ACNode childNode = this.child.get(character);
        if (childNode == null) {
            childNode = new ACNode(character);
            this.child.put(character, childNode);
        }
        return childNode;
    }

    public ACNode findNode(char character) {
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

    public ACNode getFail() {
        return fail;
    }

    public void setFail(ACNode fail) {
        this.fail = fail;
    }

    public Map<Character, ACNode> getChild() {
        return child;
    }

    public void setChild(Map<Character, ACNode> child) {
        this.child = child;
    }
}
