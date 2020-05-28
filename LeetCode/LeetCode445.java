package com.tuniu.htl.agoda.aayuan;

import java.util.Stack;

/**
 * @author kangzhe
 * @description 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转
 * @date 2020/4/14 15:50
 */
public class LeetCode445 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //数字最高位位于链表开始位置 两数相加时是从最低位开始的，本题是逆着的，放入栈中，再取出来就顺过来了，（先低位后高位）
        Stack<Integer> firstNum = new Stack<>();
        Stack<Integer> secondNum = new Stack<>();
        //l1,l2存入栈中
        while (l1 != null) {
            firstNum.push(l1.val); //入栈
            l1 = l1.next; //后移
        }
        while (l2 != null) {
            secondNum.push(l2.val);
            l2 = l2.next;
        }

        //声明新的链表用于保存结果
        ListNode retNum = null;
        //进位
        int carry = 0;
        //加法实现
        //两个数中至少有一位是不为空时，或者有进位
        while (!firstNum.isEmpty() || !secondNum.isEmpty() || carry > 0) {
            //和 = 数字1+数字2+进位  数字1 = null(0)/数字  数字2 = null(0)/数字
            int sum = firstNum.isEmpty() ? 0 : firstNum.pop();
            sum += secondNum.isEmpty() ? 0 : secondNum.pop();
            sum += carry;
            //新的进位判断 sum/10的结果就是新的carry
            carry = sum / 10;
            //低位 sum%10 要保证结果的顺序在链表中也是头部是高位，每次插入时采用头插法
            ListNode currentNum = new ListNode(sum % 10);
//            currentNum.next = retNum.next;  // retNum.next = null,空指针
//            retNum.next = currentNum;

            //将现在的数字作为头节点，
            currentNum.next = retNum;
            retNum = currentNum;

        }
        return retNum;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(12);
        ListNode l2 = new ListNode(18);
        ListNode node = addTwoNumbers(l1,l2);

    }

}
