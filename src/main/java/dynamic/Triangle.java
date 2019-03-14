package dynamic;

/**
 * 杨辉三角求最短路径
 *
 * @author : Ge Xiantao
 * @date : 2019/3/13 16:30
 */
public class Triangle {

    public static int yanghuiTriangle(int[][] triangle) {
        int[][] states = new int[triangle.length][triangle.length];
        states[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    states[i][j] = states[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    states[i][j] = states[i - 1][j - 1] + triangle[i][j];
                } else {
                    int left = states[i - 1][j - 1];
                    int right = states[i - 1][j];
                    states[i][j] = Math.min(left, right) + triangle[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            if (states[triangle.length - 1][i] < min) {
                min = states[triangle.length - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] triangle = {{5}, {7, 8}, {2, 3, 4}, {5, 7, 7, 2}, {2, 4, 6, 1,
                                                                   9}};
        int value = yanghuiTriangle(triangle);
        System.out.println(value);
    }

}
