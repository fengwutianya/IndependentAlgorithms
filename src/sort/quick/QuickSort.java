package sort.quick;

/** O(nlogn) 0(n^2) 不稳定
 * Created by xuan on 2017/9/12 0012.
 */
public class QuickSort {
    public static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int j = partition(arr, start, end);
        sort(arr, start, j-1);
        sort(arr, j+1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int x = arr[i];// i第一个作为坑
        while (i < j) {
            //从右开始
            while (i < j && arr[j] >= x) j--;
            if (i < j) {
                arr[i] = arr[j];//j第二个坑
                i++;
            }
            while (i < j && arr[i] <= x) i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;//i == j
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 2, 4, 1, 7};
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
