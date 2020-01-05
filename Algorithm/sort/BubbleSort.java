package com.tuniu.cls.rcl.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @date 2019/12/24 18:39
 */

public class BubbleSort {

    public static void sortVersion_1(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void sortVersion_2(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行交换，所以不是有序的，标记变成false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }


    public static void sortVersion_3(int array[]) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无需数列的边界，每次比较只需比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行了交换，所以不是有序的，标记变成false
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) break;
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sortVersion_1(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sortVersion_2(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sortVersion_3(array3);
        System.out.println(Arrays.toString(array3));
    }

}
