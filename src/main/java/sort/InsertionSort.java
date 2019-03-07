package sort;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/22 15:09
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int tem = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tem) {
                    arr[j + 1] = arr[j];
                } else{
                    break;
                }
            }
            arr[j + 1] = tem;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000);
        }
        long start = System.currentTimeMillis();
        insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
