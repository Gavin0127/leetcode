package dynamic;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/14 11:55
 */
public class MinDistence {

    public static int minDistance(int[][] matrix, int row, int column) {
        int[][] states = new int[matrix.length][matrix[0].length];
        states[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            states[i][0] = states[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            states[0][i] = states[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                states[i][j] =
                        Math.min(states[i - 1][j], states[i][j - 1]) +
                        matrix[i][j];
            }
        }
        return states[row][column];

    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();
        System.out.println("Matrix: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = random.nextInt(9) + 1;
                System.out.print(matrix[row][column] + "  ");
            }
            System.out.println();
        }
        System.out.println("minDistance: " + minDistance(matrix,
                                                         matrix.length - 1
                , matrix[matrix.length - 1].length - 1));
    }

}
