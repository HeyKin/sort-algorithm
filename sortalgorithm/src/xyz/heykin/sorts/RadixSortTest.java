package xyz.heykin.sorts;

import xyz.heykin.bean.Node;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 基数排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-24 10:41
 * @Since: 1.0
 **/
public class RadixSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        radixSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }



    /**
     * @Description: 基数排序,增加判断可处理负数与正数
     * @Param: [arr]
     * @return: void
     * @Author: <a href="http://heykin.xyz">heykin</a>
     * @Date: 2019/1/24
     */
    public static void radixSort(int[] arr) {

        if(arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        int maxNum = arr[0],minNum = arr[0];
        for(int i = 1;i < arr.length;i++) {
            if(arr[i] > maxNum) {
                maxNum = arr[i];
            }

            if(arr[i] < minNum) {
                minNum = arr[i];
            }
        }

        int count = Math.max(getUnit(maxNum), minNum >= 0 ? 1 : getUnit(~minNum + 1));

        Node[] tmpArr;
        Node[] mTmpArr;

        int idx = 0;
        int idx1;
        while((idx++) < count) {
            tmpArr = new Node[10];
            mTmpArr = new Node[10];
            for(int i = 0;i < len;i++) {
                if(arr[i] < 0) {
                    idx1 = getNum(~arr[i] + 1, idx);
                    mTmpArr[idx1] = new Node(arr[i], mTmpArr[idx1], mTmpArr[idx1] == null ? 1 : (mTmpArr[idx1].getCount() + 1));
                } else {
                    idx1 = getNum(arr[i], idx);
                    tmpArr[idx1] = new Node(arr[i], tmpArr[idx1], tmpArr[idx1] == null ? 1 : (tmpArr[idx1].getCount() + 1));
                }
            }

            ascSwapArr(arr, tmpArr, descSwapArr(arr, mTmpArr, 0));
        }
    }

    /**
     * 中间数组倒序交换回原数组arr,用于负数
     * @param arr
     * @param tmpArr
     * @param oIdx
     * @return
     */
    public static int descSwapArr(int[] arr, Node[] tmpArr, int oIdx) {
        for(int i = tmpArr.length - 1;i >= 0;i--) {
            Node node = tmpArr[i];
            if(node != null) {
                oIdx += node.getCount();
                int tmp = oIdx;
                while (node != null) {
                    arr[--tmp] = node.getV();
                    node = node.getNext();
                }
            }
        }
        return oIdx;
    }


    /**
     * 中间数组正序交换回原数组arr,用于正数
     * @param arr
     * @param tmpArr
     * @param oIdx
     * @return
     */
    public static int ascSwapArr(int[] arr, Node[] tmpArr, int oIdx) {
        for(int i = 0;i < tmpArr.length;i++) {
            Node node = tmpArr[i];
            if(node != null) {
                oIdx += node.getCount();
                int tmp = oIdx;
                while (node != null) {
                    arr[--tmp] = node.getV();
                    node = node.getNext();
                }
            }
        }
        return oIdx;
    }


    /**
     * 获取num指定位置的数字,从右到左,超过最大位数则返回0
     * @param num
     * @param idx 从1开始
     * @return
     */
    public static int getNum(int num, int idx) {
        return (num / (int) Math.pow(10,idx - 1)) % 10;
    }


    /**
     * 确认num是几位数
     * @param num
     * @return
     */
    public static int getUnit(int num) {
        int count = 1;
        while(num > 9) {
            num /= 10;
            count++;
        }
        return count;
    }
}
