package sort.merge;

/**
 * o(nlogn) o(nlogn) 稳定
 * Created by xuan on 2017/9/12 0012.
 */
public class MergeSort {
    public static void sort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        sort(arr, start, mid, temp);
        sort(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = start;
        int k = 0;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        for (int m = 0; m < k; m++) {
            arr[start + m] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 3, 6, 2, 4, 7};
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
