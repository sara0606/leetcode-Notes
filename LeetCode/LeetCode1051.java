package com.huibur.ass.hwserver.ayuan;

import java.util.Arrays;

/**
 * @date 2020/5/28 15:45
 */
public class LeetCode1051 {
    /**
     * 高度检查器
     * @param heights
     * @return
     */
    public static int heightChecker(int[] heights) {
      int ret = 0;
      int[] copy = Arrays.copyOf(heights, heights.length);
      Arrays.sort(copy);

      //copy中对应下标元素和heights不等，+1
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) ret ++;
        }

      return ret;
    }

    public static void main(String[] args) {
        int[] num = {5, 1, 2, 3, 4};
        int ret = heightChecker(num);
        System.out.println(ret);
    }
}
