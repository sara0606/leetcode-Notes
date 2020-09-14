package com.training.org.controller;

/**
 * 说明:
 *
 * @author kz
 * @date 2020/6/13 22:34
 * <p>
 * <br>UpdateNote:
 * <br>UpdateTime:
 * <br>UpdateUser:
 */
public class LeetCode5420 {

    public static int[] finalPrices(int[] prices) {

        int[] ret = prices;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <=prices[i]) {
                    ret[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ret;
    }





    public static void main(String[] args) {
        int[] prices = {10, 1, 1, 6};
        int[] ret = finalPrices(prices);

    }
}
