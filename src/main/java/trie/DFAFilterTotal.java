package trie;

import java.util.HashSet;
import java.util.Set;

/**
 * 完全匹配
 * @author : Ge Xiantao
 * @date : 2019/3/8 16:47
 */
public class DFAFilterTotal {

    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        DFAFilterTotal DFA = new DFAFilterTotal();
        Set<String> dirtyWords = new HashSet<>();
        dirtyWords.add("日本人");
        dirtyWords.add("人类");
        dirtyWords.add("日本鬼子");
        dirtyWords.add("日本柜子");
        dirtyWords.add("共产党");
        dirtyWords.add("毛泽东");
        DFA.init(dirtyWords);
        String source = "日本人类中的日本鬼子是被毛泽东带领的共产党打败的";
        Set<MatchedResult> matchedResults = DFA.filter(source);
        for (MatchedResult result : matchedResults) {
            System.out.println("startIndex: " + result.getStartIndex() + " " +
                               "dirtyWord: " + result.getDirtyWord());
        }
        System.out.println(DFA.replace(source));
    }

    public void init(Set<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int index = 0; index < chars.length; index++) {
                node = node.insertNode(chars[index]);
                if (index == chars.length - 1) {
                    node.setDirtyWord(word);
                }
            }
        }
        this.root = root;
    }

    public Set<MatchedResult> filter(String source) {
        Set<MatchedResult> results = new HashSet<>();
        char[] chars = source.toCharArray();
        doFilter(chars, 0, results, this.root);
        return results;
    }

    /**
     * 完全匹配
     *
     * @param source
     * @param startIndex
     * @param results
     * @param rootNode
     */
    private void doFilter(char[] source, int startIndex,
                          Set<MatchedResult> results,
                          TrieNode rootNode) {
        TrieNode node = rootNode;
        for (int index = startIndex; index < source.length; index++) {
            node = node.findNode(source[index]);
            if (node != null && node.getDirtyWord() != null &&
                node.getDirtyWord().length() > 0) {
                results.add(
                        MatchedResult.valueOf(startIndex, node.getDirtyWord()));
            }
            if (node == null) {
                doFilter(source, ++startIndex, results, rootNode);
                break;
            }
        }
    }

    private String replace(String source) {
        Set<MatchedResult> matchedResults = filter(source);
        char[] replacedChars = source.toCharArray();
        for (MatchedResult result : matchedResults) {
            for (int i = result.getStartIndex();
                 i < result.getStartIndex() + result.getDirtyWord().length();
                 i++) {
                replacedChars[i] = '*';
            }
        }
        return new String(replacedChars);
    }

}
