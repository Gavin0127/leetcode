package dynamic;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/14 15:09
 */
public class Coin {

    public static int minCoin(int[] coins, int money) {
        int levelNum = money / coins[0];
        int[][] states = new int[levelNum][money + 1];
        for (int i = 0; i < levelNum; i++) {
            for (int j = 0; j < money + 1; j++) {
                states[i][j] = -1;
            }
        }
        for (int coin : coins) {
            states[0][coin] = coin;
        }
        for (int i = 1; i < levelNum; i++) {
            for (int j = 0; j < money + 1; j++) {
                if (states[i - 1][j] != -1) {
                    for (int coin : coins) {
                        if (j + coin > money) {
                            continue;
                        }
                        states[i][j + coin] = coin;
                    }
                }
            }
        }
        int num = -1;
        for (int i = 0; i < levelNum; i++) {
            if (states[i][money] > 0) {
                num = i + 1;
                break;
            }

        }
        int beforeValue = money;
        for (int i = num - 1; i >= 0; i--) {
            for (int j = money; j >= 0; j--) {
                if (j == beforeValue) {
                    System.out.println("coin: " + states[i][j]);
                    beforeValue -= states[i][j];
                    break;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 4};
        int money = 10;
        System.out.println("coins: ");
        for (int coin : coins) {
            System.out.print(coin + "  ");
        }
        System.out.println();
        System.out.println("money: " + money);
        System.out.println("minCoin: " + minCoin(coins, money));

    }

}
