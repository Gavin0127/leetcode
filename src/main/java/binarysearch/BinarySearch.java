package binarysearch;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/26 20:34
 */
public class BinarySearch {

    public static int bSearch(int[] arr, int value) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int bSearchRecurively(int[] arr, int value) {
        return doBinarySearch(arr, 0, arr.length - 1, value);
    }

    private static int doBinarySearch(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return arr[mid];
        }
        if (arr[mid] > value) {
            return doBinarySearch(arr, low, mid - 1, value);
        } else {
            return doBinarySearch(arr, mid + 1, high, value);
        }
    }

    public static int bSearchFirst(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int ret = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                ret = mid;
                break;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = ret - 1; i >= 0; i--) {
            if (arr[i] == arr[ret]) {
                ret = i;
            } else {
                break;
            }
        }
        return ret;
    }

    public static int bSearchFirst1(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static int bSearchLast(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int ret = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                ret = mid;
                break;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = ret + 1; i < arr.length; i++) {
            if (arr[i] == arr[ret]) {
                ret = i;
            } else {
                break;
            }
        }
        return ret;
    }

    public static int bSearchFirstEqualOrGreater(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int ret = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                ret = mid;
                break;
            }
            if (arr[mid] > value) {
                high = mid - 1;
                ret = mid;
            } else {
                low = mid + 1;
            }
        }
        for (int i = ret - 1; i >= 0; i--) {
            if (arr[i] >= value) {
                ret = i;
            } else {
                break;
            }
        }
        return ret;
    }

    public static int bSearchLastEqualOrLess(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int ret = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                ret = mid;
                break;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ret = mid;
            }
        }
        for (int i = ret + 1; i < arr.length; i++) {
            if (arr[i] <= value) {
                ret = i;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 4, 5, 6, 10, 11, 13, 13, 16, 21,
                              43};
        int firstRet = bSearchFirst(arr, 4);
        System.out.println(firstRet);
        int lastRet = bSearchLast(arr, 4);
        System.out.println(lastRet);
        int firstEqualOrGreater = bSearchFirstEqualOrGreater(arr, 8);
        System.out.println(firstEqualOrGreater);
        int lastEqualOrLess = bSearchLastEqualOrLess(arr, 13);
        System.out.println(lastEqualOrLess);
    }


}
