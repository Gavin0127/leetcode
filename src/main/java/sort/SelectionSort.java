package sort;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/22 15:10
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }

    }

    private static void exchange(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
        int[] arr = new int[20000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000);
        }
        long start = System.currentTimeMillis();
        selectionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
