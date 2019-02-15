package xyz.heykin.sorts;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 归并排序
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:00
 * @Since: 1.0
 **/
public class MergeSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }

    
    
    /** 
    * @Description: 归并排序实现
    * @Param: [arr, startIndex, endIndex] 
    * @return: void 
    * @Author: heykin
    * @Date: 2019/1/25 
    */ 
    public static void mergeSort(int[] arr, Integer startIndex, Integer endIndex) {
        if(arr == null  || arr.length == 0) {
            return;
        }

        if(startIndex < endIndex) {
            int len = endIndex - startIndex + 1;//数组长度
            int mid = (endIndex + startIndex) / 2;//中点
            mergeSort(arr, startIndex, mid);
            mergeSort(arr, mid + 1, endIndex);

            int[] tmpArr = new int[len];//临时数组,用来存放排好序的数
            int k = 0;
            int temSIndex = startIndex;
            int temEIndex = mid + 1;

            //当temSIndex大于中点下标或temEIndex大于数组最大下标时结束循环
            while(temSIndex <= mid && temEIndex <= endIndex) {
                //左边与右边比较
                if(arr[temSIndex] < arr[temEIndex]) {
                    tmpArr[k++] = arr[temSIndex++];
                } else {
                    tmpArr[k++] = arr[temEIndex++];
                }
            }

            //将左边未排完的数排进临时数组
            while(temSIndex <= mid) {
                tmpArr[k++] = arr[temSIndex++];
            }

            //将右边未排完的数排进临时数组
            while(temEIndex <= endIndex) {
                tmpArr[k++] = arr[temEIndex++];
            }

            //把临时数组内的数交换回arr数组
            for(int i = 0;i < tmpArr.length;i++) {
                arr[startIndex + i] = tmpArr[i];
            }
        }
    }
}
