package com.tuniu.htl.agoda.aayuan;

/**
 * @author kangzhe
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @date 2020/4/14 14:34
 */
public class LeetCode70 {

    /**
     * 1  1
     * 2  2
     * 3  3 = 2+1
     * 4  5 = 3+2
     * 5  8 = 5+3
     * 6  13 = 8+5
     * <p>
     * 和那个斐波那契额有点像  Ai = Ai-1 + Ai-2
     * 动态规划
     * <p>
     * 第 ii 阶可以由以下两种方法得到：
     * 在第 (i-1)阶后向上爬一阶。
     * 在第 (i-2) 阶后向上爬 22 阶。
     * 所以到达第 ii 阶的方法总数就是到第 (i−1) 阶和第 (i−2) 阶的方法数之和。
     * 令 dp[i] 表示能到达第 ii 阶的方法总数：
     * dp[i]=dp[i-1]+dp[i-2]
     * <p>
     * <p>
     * 小结：我是用举例子数学算式推算出的规律，后边动态规划的思想更优。
     * 我把斐波那契和动态规划混淆了。
     *
     * @param n n个台阶
     * @return 几种方法
     */

    //动态规划
    public static int climbStairs(int n) {

        //特殊情况判断
        if (n == 1 || n == 2) return n;

        int[] A = new int[n + 1];
        A[1] = 1;
        A[2] = 2;
        for (int i = 3; i <= n; i++) {
            A[i] = A[i - 1] + A[i - 2];
        }
        return A[n];
    }

    //斐波那契
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        int ret = climbStairs(4);
        System.out.println(ret);
    }

}
