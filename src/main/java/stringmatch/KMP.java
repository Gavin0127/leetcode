package stringmatch;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/7 10:35
 */
public class KMP {

    public static int KMP(String source, String pattern) {
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int[] nexts = getNexts(p);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = nexts[j];
            }
            if (j ==-1 || s[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                return i - p.length + 1;
            }
        }
        return -1;
    }

    private static int[] getNexts(char[] patternStr) {
        int[] next = new int[patternStr.length];
        int k = -1;
        next[0] = k;
        for (int i = 1; i < patternStr.length; i++) {
            while (k != -1 && patternStr[k + 1] != patternStr[i]) {
                k = next[k];
            }
            if (patternStr[k + 1] == patternStr[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String source = "abcabcaa";
        String target = "caa";
        System.out.println(KMP(source, target));
    }

}
