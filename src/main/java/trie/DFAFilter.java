package trie;

import java.util.HashSet;
import java.util.Set;

/**
 * 确定有限状态机
 *
 * @author : Ge Xiantao
 * @date : 2019/3/7 16:11
 */
public class DFAFilter {

    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        DFAFilter DFA = new DFAFilter();
        Set<String> dirtyWords = new HashSet<>();
        dirtyWords.add("日本人");
        dirtyWords.add("日本鬼子");
        dirtyWords.add("日本柜子");
        dirtyWords.add("共产党");
        dirtyWords.add("毛泽东");
        DFA.init(dirtyWords);
        String source = "日本人中的日本鬼子是被毛泽东带领的共产党打败的";
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
        filter(source, 0, results, this.root);
        return results;
    }

    private void filter(String source, int startIndex,
                                     Set<MatchedResult> results,
                        TrieNode rootNode) {
        char[] chars = source.toCharArray();
        TrieNode node = rootNode;
        for (int index = startIndex; index < chars.length; index++) {
            node = node.findNode(chars[index]);
            if (node != null && node.getDirtyWord() != null &&
                node.getDirtyWord().length() > 0) {
                results.add(
                        MatchedResult.valueOf(startIndex, node.getDirtyWord()));
            }
            if (node == null) {
                filter(source, ++index, results, rootNode);
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
