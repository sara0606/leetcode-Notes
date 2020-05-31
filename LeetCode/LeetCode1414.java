package com.huibur.ass.biz.ayuan;

/**
 * @date 2020/5/31 14:24
 */
public class LeetCode1414 {
//    F1 = 1
//    F2 = 1
//    Fn = Fn-1 + Fn-2 ， 其中 n > 2 。

    /**
     * 最小组合的个数中的每个数必然是 fib 数。
     *
     * 下面反证法证明：
     * 如果组合中的数不是 fib 数，那么该数的最小组合中数的个数必然是大于1的，就可以进一步分解，分解之后同理可证，最后得到最后的每个数必然是 fib 数。
     *
     * 每次必然通过减小最大 fib 数来减小问题的规模
     *
     * 由上面可知，组合中的数必然都是 fib 数，那么 fib 数必然是越大，组成该数的组合中的个数才会越小。
     * @param k
     * @return
     */

    public static int findMinFibonacciNumbers(int k) {
        if (k == 0) return 0;
        if (k == 1 || k == 2) return 1;
        int g = 1, f = 1;
        while (g < k) {
            g = g + f;
            f = g - f;
        }
        if (g == k) f = g;
        return 1 + findMinFibonacciNumbers(k - f);
    }

}
