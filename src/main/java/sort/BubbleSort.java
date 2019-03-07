package sort;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/22 12:14
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
