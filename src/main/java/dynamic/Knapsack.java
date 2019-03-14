package dynamic;

import trie.TrieNode;

import java.lang.annotation.Target;
import java.util.Random;

/**
 * 0-1背包问题
 *
 * @author : Ge Xiantao
 * @date : 2019/3/13 11:08
 */
public class Knapsack {

    /**
     * 使用二维数组
     * @param weight
     * @param num
     * @param maxWeight
     * @return
     */
    public static int knapsack(int[] weight, int num, int maxWeight) {
        boolean[][] state = new boolean[num][maxWeight + 1];
        state[1][weight[0]] = true;
        state[0][0] = true;
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // 不把第i个物品放入背包
                if (state[i - 1][j]) {
                    state[i][j] = true;
                }
            }
            for (int j = 0; j <= maxWeight - weight[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = maxWeight; i >= 0; i--) {
            if (state[num - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 使用一维数组
     * @param weight
     * @param num
     * @param maxWeight
     * @return
     */
    public static int knapsack2(int[] weight, int num, int maxWeight) {
        boolean[] states = new boolean[maxWeight + 1];
        states[0] = true;
        states[weight[0]] = true;
        for (int i = 1; i < num; i++) {
            for (int j = maxWeight - weight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        for (int i = maxWeight; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }


    public static int knapsackValue(int[] weight, int[] value, int num,
                                    int maxWeight) {
        int[] states = new int[maxWeight + 1];
        for (int i = 0; i < states.length; i++) {
            states[i] = -1;
        }
        states[0] = 0;
        states[weight[0]] = value[0];
        for (int i = 0; i < num; i++) {
            for (int j = maxWeight - weight[i]; j >= 0; j--) {
                if (states[j] >= 0) {
                    states[j + weight[i]] = states[j] + value[i];
                }
            }
        }
        int maxValue = states[0];
        for (int state : states) {
            if (state > maxValue) {
                maxValue = state;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] weight = new int[5];
        Random random = new Random();
        for (int i = 0; i < weight.length; i++) {
            weight[i] = random.nextInt(10) + 1;
        }
        int num = 5;
        int maxWeight = 10;
        System.out.println("weights: ");
        for (int i : weight) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("nums: " + num + " maxWeight: " + maxWeight);
        int knapsack = knapsack(weight, num, maxWeight);
        int knapsack2 = knapsack2(weight, num, maxWeight);
        System.out.println("answer1: " + knapsack);
        System.out.println("answer2: " + knapsack2);
        int[] values = new int[5];
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(10) + 1;
        }
        System.out.println("values: ");
        for (int i : values) {
            System.out.print(i + " ");
        }
        System.out.println();
        int knapsackValue = knapsackValue(weight, values, num, maxWeight);
        System.out.println("answerValue: " + knapsackValue);
    }

}
