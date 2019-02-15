package xyz.heykin.sorts;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 插入排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:06
 * @Since: 1.0
 **/
public class InsertionSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        insertionSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }


    /** 
    * @Description: 插入排序实现
    * @Param: [arr] 
    * @return: void 
    * @Author: heykin
    * @Date: 2019/1/25 
    */ 
    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return ;
        }

        int len=arr.length;
        int j;//用来记录即将要排序的数的位置
        int tmp;//用来记录即将要排序的数的值

        //假设第一个元素是正确的,所以循环从1开始,循环len-1次
        for(int i = 1;i < len;i++) {
            tmp = arr[i];
            j = i;
            //从i开始从后向前开始比较,当j小于0或者tmp大于arr[j-1]时,则不再停止比较
            for(;j > 0 && tmp < arr[j-1];j--) {
                arr[j] = arr[j-1];
            }
            //交换值
            arr[j] = tmp;
        }
    }
}
