package com.huibur.ass.biz.ayuan;

import java.util.Arrays;

/**
 * @date 2020/5/31 11:44
 */
public class LeetCode5425 {

    /**
     * 切割后面积最大的蛋糕
     *
     * 贪心
     * @param h 高
     * @param w 宽
     * @param horizontalCuts 高度切割位置
     * @param verticalCuts 宽度切割位置
     * @return 最大面积
     */
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long horizonMax = 0, verticalMax = 0;
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for (int i = 1; i < horizontalCuts.length; i++) {
            horizonMax = Math.max(horizonMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        // 补充验证边界切割位置
        horizonMax = Math.max(horizonMax, horizontalCuts[0] - 0);
        horizonMax = Math.max(horizonMax, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        // 补充验证边界切割位置
        verticalMax = Math.max(verticalMax, verticalCuts[0] - 0);
        verticalMax = Math.max(verticalMax, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((horizonMax * verticalMax) % mod);
    }

    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int[] ho = {3, 1};
        int[] ve = {1};
        int ret = maxArea(h,w,ho,ve);
    }
}
