package xyz.heykin.sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 快速排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 19:53
 * @Since: 1.0
 **/
public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-10,44,32,12,6,3,-30,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        /*int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);*/
    }


    /** 
    * @Description: 快速排序实现
    * @Param: [arr, startIndex, endIndex] 
    * @return: void 
    * @Author: heykin
    * @Date: 2019/1/25 
    */ 
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if(arr == null  || arr.length == 0) {
            return;
        }


        if(endIndex > startIndex) {
            int idx = startIndex + 1;//记录要交换的下标
            int len = endIndex + 1;//得到要比较数组段的长度

            //循环从idx下标开始
            for(int i = idx;i < len;i++) {
                //若arr[i]小于基准数,则进行交换,并且idx+1
                if(arr[i] < arr[startIndex]) {
                    int tmp = arr[idx];
                    arr[idx] = arr[i];
                    arr[i] = tmp;
                    idx++;
                }
            }

            if(idx > startIndex) {
                int tmp = arr[--idx];
                arr[idx] = arr[startIndex];
                arr[startIndex] = tmp;
            }

            quickSort(arr, startIndex, idx - 1);
            quickSort(arr, idx + 1, endIndex);
        }
    }
}
