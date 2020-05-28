package com.tuniu.htl.agoda.aatuan;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        Stack<Integer> stackA = toStack(a);
        Stack<Integer> stackB = toStack(b);

        Stack<ListNode> stackX = new Stack<>();

        int carry = 0;

        while(!stackA.isEmpty() || !stackB.isEmpty() || carry > 0){
            int x = stackA.isEmpty() ? 0 : stackA.pop();
            int y = stackB.isEmpty() ? 0 : stackB.pop();

            int d = x + y + carry;
            carry = 0;

            if(d > 9){
                carry = 1;
                d %= 10;
            }

            ListNode neo = new ListNode(d);
            if(!stackX.isEmpty()){
                neo.next = stackX.peek();
            }
            stackX.push(neo);
        }

        return stackX.pop();

    }

    private Stack<Integer> toStack(ListNode n){
        Stack<Integer> stack = new Stack<>();
        do{
            stack.push(n.val);
            n = n.next;
        }while(n != null);
        return stack;
    }
}