package CodeWars;

/**
 * @author yuanyuan
 * @Desc 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Date 2020/9/8 15:41
 */
public class BestTimeToBuyAndSellStockII_122 {

    /**
     * 我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值。
     * 最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，
     * 但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，
     * 我们获得的总和将是最大利润。
     * <p>
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            //先买后卖，后边的价格高于前边的，即卖出高于买入，那么就会有盈利prices[i] - prices[i - 1];
            if (prices[i] > prices[i - 1]) {
                ret = ret + prices[i] - prices[i - 1];
            }
        }
        return ret;

    }
}
