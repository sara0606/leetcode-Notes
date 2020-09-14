package com.isoftstone.file.vacamanager.ayuan;

/**
 * @author kangzhe
 * @Desc 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * https://leetcode-cn.com/problems/plus-one/
 * @Date 2020/9/7 17:15
 */
public class PluOne_66 {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            //末位+1
            digits[i]++;
            digits[i] = digits[i] % 10;
            //判断是否有进位
            if (digits[i] != 0) {
                //无进位，直接返回+1的结果
                return digits;
            }
        }
        //如：999+1=1000，长度为增加一位，最前边会有一个进位1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
