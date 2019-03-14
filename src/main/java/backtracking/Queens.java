package backtracking;

/**
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 * 你可以看我画的图，第一幅图是满足条件的一种方法，第二幅图是不满足条件的。
 * 八皇后问题就是期望找到所有满足这种要求的放棋子方式。
 *
 * @author : Ge Xiantao
 * @date : 2019/3/12 15:54
 */
public class Queens {

    private int[] result = new int[8];

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        for (int i = row - 1, offset = 1; i >= 0; i--, offset++) {
            if (result[i] == column) {
                return false;
            }
            if (column - offset >= 0) {
                if (result[i] == column - offset) {
                    return false;
                }
            }
            if (column + offset < 8) {
                if (result[i] == column + offset) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printQueens(int[] result) {
        System.out.println();
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q  ");
                } else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queens queens = new Queens();
        queens.cal8Queens(0);
    }

}
