package trie.ac;

import trie.DFAFilter;
import trie.MatchedResult;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/8 14:23
 */
public class ACFilter {

    private ACNode root;

    public static void main(String[] args) {
        ACFilter acFilter = new ACFilter();
        Set<String> dirtyWords = new HashSet<>();
        dirtyWords.add("日本人");
        dirtyWords.add("日本鬼子");
        dirtyWords.add("日本柜子");
        dirtyWords.add("共产党");
        dirtyWords.add("毛泽东");
        acFilter.init(dirtyWords);
        String source = "日本人中的日本鬼子是被毛泽东带领的共产党打败的";
        Set<MatchedResult> matchedResults = acFilter.filter(source);
        for (MatchedResult result : matchedResults) {
            System.out.println("startIndex: " + result.getStartIndex() + " " +
                               "dirtyWord: " + result.getDirtyWord());
        }
        System.out.println(acFilter.replace(source));
    }

    public void init(Set<String> words) {
        ACNode root = new ACNode();
        for (String word : words) {
            char[] chars = word.toCharArray();
            ACNode node = root;
            for (int index = 0; index < chars.length; index++) {
                node = node.insertNode(chars[index]);
                if (index == chars.length - 1) {
                    node.setDirtyWord(word);
                }
            }
        }
        this.root = root;
        buildFailurePointer(root);

    }

    public void buildFailurePointer(ACNode root) {
        root.setFail(null);
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACNode p = queue.remove();
            for (ACNode childNode : p.getChild().values()) {
                ACNode pFail = p.getFail();
                if (p == root) {
                    childNode.setFail(root);
                } else {
                    if (pFail.getChild()
                             .containsKey(childNode.getCharacter())) {
                        childNode.setFail(
                                pFail.getChild().get(childNode.getCharacter()));
                    } else {
                        pFail = pFail.getFail();
                        while (pFail != null) {
                            if (pFail.getChild()
                                     .containsKey(childNode.getCharacter())) {
                                childNode.setFail(
                                        pFail.getChild()
                                             .get(childNode.getCharacter()));
                                break;
                            } else {
                                pFail = pFail.getFail();
                            }
                        }
                        if (pFail == null) {
                            childNode.setFail(root);
                        }
                    }
                }
                queue.add(childNode);
            }
        }
    }

    public Set<MatchedResult> filter(String source) {
        Set<MatchedResult> results = new HashSet<>();
        char[] chars = source.toCharArray();
        doFilter(chars, 0, results, this.root);
        return results;
    }

    private void doFilter(char[] source, int startIndex,
                          Set<MatchedResult> results,
                          ACNode rootNode) {
        int start = startIndex;
        ACNode pNode = rootNode;
        ACNode cNode;
        for (int i = startIndex; i < source.length; i++) {
            cNode = pNode.findNode(source[i]);
            if (cNode != null && cNode.getDirtyWord() != null &&
                cNode.getDirtyWord().length() > 0) {
                results.add(MatchedResult.valueOf(start, cNode.getDirtyWord()));
                start = i + 1;
            }
            if (cNode == null) {
                if (pNode != this.root) {
                    doFilter(source, i, results, pNode.getFail());
                }
                break;
            }
            pNode = cNode;
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
