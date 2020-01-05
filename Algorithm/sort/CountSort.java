package com.tuniu.cls.rcl.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 计数排序
 *
 * @date 2019/12/31 17:26
 */

public class CountSort {

    /**
     * 计数排序---第一版
     * <p>
     * 以数列最大值+1最为统计数组长度
     *
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        for (int value : array) {
            if (value > max)
                max = value;
        }
        //2.根据数列的最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //3.遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        //4.遍历统计数组，得到结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }


    public static int[] countSortOptimization(int[] array) {
        //1.得到数列的最大值和最小值，计算出两者差值d
        int max = array[0];
        int min = array[0];
        for (int each : array) {
            if (array[each] > max) max = array[each];
            if (array[each] < min) min = array[each];
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < countArray.length; i++) {
            countArray[array[i] - min]++;
        }
        //3.统计数组做变形,后面的元素等于前面的元素之和
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        //4.倒序遍历原始数据，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray = new int[countArray.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));

        int[] array2 = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray2 = countSortOptimization(array2);
        System.out.println(Arrays.toString(sortedArray2));
    }

}
