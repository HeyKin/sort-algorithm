package xyz.heykin.sorts;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 冒泡排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:11
 * @Since: 1.0
 **/
public class BubbleSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        bubbleSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }


    /** 
    * @Description: 冒泡排序实现
    * @Param: [arr] 
    * @return: void 
    * @Author: heykin
    * @Date: 2019/1/25 
    */ 
    public static void bubbleSort (int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        //长度为n的数组,需要循环n-1次
        for(int i=0;i < len - 1;i++) {
            //比较len-i-1次
            for(int j=0;j < len - i - 1;j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
