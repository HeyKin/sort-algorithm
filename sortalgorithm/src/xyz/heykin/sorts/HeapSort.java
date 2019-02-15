package xyz.heykin.sorts;

import java.util.Arrays;

/**
 * @Program: sortalgorithm
 * @Description: 堆排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-29 12:10
 * @Since: 1.0
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /** 
    * @Description: 堆排序实现
    * @Param: [arr] 
    * @return: void 
    * @Author: heykin
    * @Date: 2019/1/29 
    */ 
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        for(int i = (len / 2 - 1) ;i >=0;i--) {
            adjustHeap(arr, i, len);
        }

        for(int i = len - 1;i >=0;i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustHeap(arr, 0, i);
        }
    }


    public static void adjustHeap(int[] arr, int k, int len) {
        int tmp = arr[k];
        for(int i = (k * 2 + 1);i < len;i = (i * 2 + 1)) {
            if(i < (len - 1) && arr[i] < arr[i + 1]) {
                i++;
            }

            if(tmp < arr[i]) {
                arr[k] = arr[i];
                k = i;
            } else {
                break;
            }
        }
        arr[k] = tmp;
    }
}
