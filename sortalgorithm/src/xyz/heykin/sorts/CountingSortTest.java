package xyz.heykin.sorts;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 计数排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 19:56
 * @Since: 1.0
 **/
public class CountingSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        countingSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }



    /**
    * @Description:  计数排序实现,只能处理0~n的正整数 若要负数也排序,需要增加额外处理
    * @Param: [arr]
    * @return: void
    * @Author: heykin
    * @Date: 2019/1/25
    */
    public static void countingSort(int[] arr) {
        if(arr == null) {
            return;
        }

        //最大值和最小值
        int maxNum = arr[0],minNum = arr[0];
        int i,j=0;
        //遍历数组得到最大值和最小值
        for(i = 1;i < arr.length;i++) {
            if(arr[i] > maxNum) {
                maxNum = arr[i];
            }

            if(arr[i] < minNum) {
                minNum = arr[i];
            }
        }

        //声明长度为最大值+1的临时数组
        int[] tmpArr = new int[maxNum + 1];

        //循环把arr[i]对应的临时数组+1
        for(i = 0;i < arr.length;i++) {
            tmpArr[arr[i]]++;
        }

        //循环把临时数组中的数放回原数组,下标从最小值开始
        for(i = minNum;i < tmpArr.length;i++) {
            while(tmpArr[i] > 0) {
                arr[j++] = i;
                tmpArr[i]--;
            }
        }
    }
}
