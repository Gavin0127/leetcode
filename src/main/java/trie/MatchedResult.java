package trie;

import java.util.Objects;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/7 17:20
 */
public class MatchedResult {

    private int startIndex;

    private String dirtyWord;

    public static MatchedResult valueOf(int startIndex, String dirtyWord) {
        MatchedResult result = new MatchedResult();
        result.startIndex = startIndex;
        result.dirtyWord = dirtyWord;
        return result;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getDirtyWord() {
        return dirtyWord;
    }

    public void setDirtyWord(String dirtyWord) {
        this.dirtyWord = dirtyWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchedResult result = (MatchedResult) o;
        return startIndex == result.startIndex &&
               Objects.equals(dirtyWord, result.dirtyWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, dirtyWord);
    }
}
