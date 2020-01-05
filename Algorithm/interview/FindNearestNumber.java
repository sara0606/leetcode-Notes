package com.tuniu.cls.rcl.algorithm.interview;

import java.util.Arrays;

/**
 * 给出一个正整数，找出这个正整数所有数字全排列的下一个数
 * <p>
 * 在一个整数所包含数字的全部组合中，找到一个大于且仅大于原数的新整数
 *
 * @date 2020/1/3 15:22
 */

public class FindNearestNumber {

    public static int[] findNearestNumber(int[] numbers) {

        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字的置换边界是0，说明整个数字已经逆序，无法获得更大的相同数字组成的整数，返回null
        if (index == 0) return null;
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy,index);
        return numbersCopy;

    }

    private static int findTransferPoint(int[] numbers) {

        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) return i;
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num,int index){
        for (int i = index,j = num.length-1;i<j;i++,j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static void outputNumbers(int[] numbers){
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers= new int[]{1,2,3,4,5};
        //打印12345之后的10个全排列整数
        for (int i = 0;i <10 ;i++){
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);

            System.out.println(Arrays.toString(numbers));
        }
    }

}
