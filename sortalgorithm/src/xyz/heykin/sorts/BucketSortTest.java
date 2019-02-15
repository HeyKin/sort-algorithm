package xyz.heykin.sorts;

import xyz.heykin.bean.Node;

import java.util.Random;

/**
 * @Program: sortalgorithm
 * @Description: 桶排序实现及测试
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-25 20:13
 * @Since: 1.0
 **/
public class BucketSortTest {

    public static void main(String[] args) {
        /*int[] arr = new int[]{-3,-30,44,32,12,6,3,-10,-99,5,10,65,-33,77,4,0,155,-50,-43,543,456,768,998,996,991};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[300000];
        Random r = new Random();
        for(int i = 0;i < 300000;i++) {
            arr[i] = r.nextInt(10000000);
        }
        Long s = System.currentTimeMillis();
        bucketSort(arr);
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }

    /**
     * @Description: 桶排序,增加判断可处理负数与正数
     * @Param: [arr]
     * @return: void
     * @Author: <a href="http://heykin.xyz">heykin</a>
     * @Create: 2019/1/23
     */
    public static void bucketSort(int[] arr) {
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

        Node[] tmpArr = new Node[getUnit(maxNum)];
        Node[] mTmpArr = null;
        if(minNum < 0) {
            mTmpArr = new Node[getUnit(minNum * -1)];
        }
        int idx;
        for(int i = 0;i < len;i++) {
            if(arr[i] < 0) {
                idx = getUnit(arr[i] * -1) - 1;
                mTmpArr[idx] = new Node(arr[i], mTmpArr[idx], mTmpArr[idx] == null ? 1 : (mTmpArr[idx].getCount() + 1));
            } else {
                idx = getUnit(arr[i]) - 1;
                tmpArr[idx] = new Node(arr[i], tmpArr[idx], tmpArr[idx] == null ? 1 : (tmpArr[idx].getCount() + 1));
            }
        }

        idx = 0;
        int[] tmpArr1;
        if(mTmpArr != null) {
            for(int i = mTmpArr.length - 1;i >= 0;i--) {
                Node node = mTmpArr[i];
                if(node != null) {
                    int count = 0;
                    tmpArr1 = new int[node.getCount()];
                    while (node != null) {
                        tmpArr1[count++] = node.getV();
                        node = node.getNext();
                    }
                    QuickSortTest.quickSort(tmpArr1, 0, tmpArr1.length -1);
                    for(int j = 0;j < tmpArr1.length;j++) {
                        arr[idx++] = tmpArr1[j];
                    }
                }
            }
        }


        for(int i = 0;i < tmpArr.length;i++) {
            Node node = tmpArr[i];
            if(node != null) {
                int count = 0;
                tmpArr1 = new int[node.getCount()];
                while (node != null) {
                    tmpArr1[count++] = node.getV();
                    node = node.getNext();
                }
                QuickSortTest.quickSort(tmpArr1, 0, tmpArr1.length -1);
                for(int j = 0;j < tmpArr1.length;j++) {
                    arr[idx++] = tmpArr1[j];
                }
            }
        }

    }

    public static int getUnit(int num) {
        int count = 1;
        while(num > 9) {
            num /= 10;
            count++;
        }
        return count;
    }
}
