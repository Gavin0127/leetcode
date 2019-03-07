package sort;

import java.util.Random;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/22 18:06
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return new int[]{arr[start]};
        }
        int mid = (start + end) / 2;
        return mergeArr(mergeSort(arr, start, mid),
                        mergeSort(arr, mid + 1, end));
    }

    private static int[] mergeArr(int[] arr1, int[] arr2) {
        int[] finalArr = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < finalArr.length; i++) {
            if (index1 > arr1.length - 1 && index2 <= arr2.length - 1) {
                finalArr[i] = arr2[index2++];
                continue;
            }
            if (index2 > arr2.length - 1 && index1 <= arr1.length - 1) {
                finalArr[i] = arr1[index1++];
                continue;
            }
            if (arr1[index1] < arr2[index2]) {
                finalArr[i] = arr1[index1++];
            } else {
                finalArr[i] = arr2[index2++];
            }
        }
        return finalArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[20000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000);
        }
        long start = System.currentTimeMillis();
        int[] ret = mergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }

}
