package com.tuniu.cls.rcl.algorithm.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 *
 *
 * @date 2019/12/25 10:19
 */

public class CocktailSort {

    public static void cocktailSort(int[] array) {

        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，所以不是有序的，标记变成false
                    isSorted = false;
                }
            }
            if (isSorted) break;
            //在偶数轮之前，将isSorted重新标记成true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //因为有元素进行交换，所以不是有序的，标记变成false
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }

}
