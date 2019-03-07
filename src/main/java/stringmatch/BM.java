package stringmatch;

/**
 * BM算法， 坏字符&&好后缀
 * @author : Ge Xiantao
 * @date : 2019/3/5 17:47
 */
public class BM {

    private static final int SIZE = 256;

    private static int[] generateBC(char[] target) {
        int[] bc = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < target.length; i++) {
            int ascii = target[i];
            bc[ascii] = i;
        }
        return bc;
    }

    public static int bm(char[] source, char[] target) {
        int sourceLen = source.length;
        int targetLen = target.length;
        int[] bc = generateBC(target);
        int[] suffix = new int[targetLen];
        boolean[] prefix = new boolean[targetLen];
        generateGS(target, suffix, prefix);
        int firstMatch = 0;
        while (firstMatch <= sourceLen - targetLen) {
            int i;
            for (i = targetLen - 1; i >= 0; i--) {
                if (source[firstMatch + i] != target[i]) {
                    break;
                }
            }
            if (i < 0) {
                return firstMatch;
            }
            int badChar = i - bc[source[firstMatch + i]];
            int goodSuffix = 0;
            if (i < targetLen - 1) {
                goodSuffix = moveByGS(i, targetLen, suffix, prefix);
            }
            firstMatch += Math.max(badChar, goodSuffix);
        }
        return -1;
    }

    private static int moveByGS(int i, int targetLen, int[] suffix,
                                boolean[] prefix) {
        // 好后缀长度
        int k = targetLen - 1 - i;
        if (suffix[k] != -1) {
            return i - suffix[k] + 1;
        }
        for (int r = i + 2; r <= targetLen - 1; r++) {
            if (prefix[targetLen - r]) {
                return r;
            }
        }
        return targetLen;
    }

    private static void generateGS(char[] target, int[] suffix,
                                   boolean[] prefix) {
        for (int i = 0; i < target.length; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        int targetLen = target.length;
        for (int i = 0; i < targetLen - 1; i++) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            while (j >= 0 && target[j] == target[targetLen - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }

    }


    public static void main(String[] args) {
        String source = "abcabcaa";
        String target = "caa";
        System.out.println(bm(source.toCharArray(), target.toCharArray()));
    }

}
