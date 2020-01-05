package com.tuniu.cls.rcl.algorithm.interview;

/**
 * 判断是不是2的整数次幂
 *
 * @date 2020/1/2 21:41
 */

public class IsPowerOfTwo {

    /**
     * 判断这个数是不是2的整数次幂
     * <p>
     * 版本1.0
     *
     * @param num 要判断的数
     * @return
     */
    public static boolean isPowerOfTwo_v1(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) return true;
            temp = temp * 2;
        }
        return false;
    }

    /**
     * 判断这个数是不是2的整数次幂
     * <p>
     * 版本1.1 位移，向左移一位等同乘2
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo_v2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) return true;
            temp = temp << 1;
        }
        return false;
    }

    /**
     * 判断这个数是不是2的整数次幂
     * <p>
     * 版本1.2
     * 凡是2的整数次幂和它本身减一的结果进行与运算，结果必定都是0
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo_v3(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo_v1(32));
        System.out.println(isPowerOfTwo_v1(19));

        System.out.println(isPowerOfTwo_v2(32));
        System.out.println(isPowerOfTwo_v2(19));

        System.out.println(isPowerOfTwo_v3(32));
        System.out.println(isPowerOfTwo_v3(19));
    }

}
