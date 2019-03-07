package binarysearch;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/27 15:41
 */
public class RotatedBinarySearch {

    public static int bSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] >= arr[low]) {
                if (arr[mid] > value && arr[low] <= value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[high] >= value && arr[mid] < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
