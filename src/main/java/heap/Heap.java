package heap;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/3/1 11:07
 */
public class Heap {

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int end = arr.length - 1;
        while (end > 1) {
            swap(arr, 1, end--);
            heapify(arr, 1, end);
        }
    }

    /**
     * 自上而下堆化
     * @param arr
     * @param i
     * @param end
     */
    private static void heapify(int[] arr, int i, int end) {
        while (true) {
            int maxPos = i;
            int left = i * 2;
            int right = i * 2 + 1;
            if (left <= end && arr[left] > arr[i]) {
                maxPos = left;
            }
            if (right <= end && arr[right] > arr[maxPos]) {
                maxPos = right;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void buildHeap(int[] arr) {
        int len = arr.length - 1;
        for (int i = len / 2; i > 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }

    public static void main(String[] args) {
        int len = 10000;
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 1; i < len; i++) {
            arr[i] = random.nextInt(len);
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("sortTimeInMillis: " + (end - start));
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
