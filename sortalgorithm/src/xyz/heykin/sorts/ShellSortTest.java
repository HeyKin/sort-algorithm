package xyz.heykin.sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 希尔排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:02
 * @Since: 1.0
 **/
public class ShellSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

        /*int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        shellSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);*/

    }


    /**
    * @Description:  希尔排序实现
    * @Param: [arr]
    * @return: void
    * @Author: heykin
    * @Date: 2019/1/25
    */
    public static void shellSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return ;
        }

        int len=arr.length;
        int step = len;
        int target;
        //step /= 2得到步长
        while((step /= 2) > 0) {
            //从step开始循环
            for(int i = step;i < len;i++) {
                int j = i;
                target = arr[i];
                while(j >= step && target < arr[j - step]) {
                    arr[j] = arr[j - step];
                    j -= step;
                }
                arr[j] = target;
            }
        }
    }
}
