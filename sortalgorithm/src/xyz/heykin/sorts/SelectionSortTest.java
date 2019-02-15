package xyz.heykin.sorts;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 选择排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:08
 * @Since: 1.0
 **/
public class SelectionSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        selectionSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }


    /** 
    * @Description: 选择排序实现
    * @Param: [arr] 
    * @return: java.lang.Integer[] 
    * @Author: heykin
    * @Date: 2019/1/25 
    */ 
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        //长度为n的数组,需要循环n-1次
        for(int i=0;i < len - 1;i++) {
            //记录下标
            int ij = i;
            //与i+1开始比较
            for(int j = i + 1;j < len;j++) {
                //若arr[j]比arr[ij]大,则更改记录下标变量
                if(arr[ij] > arr[j]) {
                    ij = j;
                }
            }

            //比较记录下标变量与i是否相等,不相等需要交换
            if(ij != i) {
                int tmp = arr[i];
                arr[i] = arr[ij];
                arr[ij] = tmp;
            }
        }
    }
}
