package com.tuniu.htl.agoda.aayuan;

/**
 * @author kangzhe
 * @description
 * @date 2020/4/13 11:28
 */
public class LeetCode121 {

    /**
     * 我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。
     * 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    /**
     * 贪心算法，从左向右，维护一个最小值minprice，与每一天的股票价格做差，差最大的为答案
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;    //定义买入为最大值
        int ret = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);//利用Math.min/max求解最小/大值
            ret = Math.max(ret, price - minPrice);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit2(prices);
    }

}
