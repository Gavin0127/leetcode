package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/25 12:21
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int pivot, int end) {
        if (pivot >= end) {
            return;
        }
        int newPivot = partition(arr, pivot, end);
        quickSort(arr, pivot, newPivot - 1);
        quickSort(arr, newPivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            if (arr[i] <= value) {
                i++;
                continue;
            }
            if (arr[j] > value) {
                j--;
                continue;
            }
            swap(arr, i++, j--);
        }
        swap(arr, start, j);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
