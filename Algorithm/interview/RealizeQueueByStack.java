package com.tuniu.cls.rcl.algorithm.interview;

import java.util.Stack;

/**
 * 用栈实现队的操作：出队，入队
 *
 * @date 2020/1/3 11:40
 */

public class RealizeQueueByStack {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队
     * @param element
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队
     * @return
     */
    public Integer deQueue(){
        if (stackB.isEmpty()){
            if (stackA.isEmpty()) return null;
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 栈A元素转移到栈B
     */
    private void transfer(){
        while (!stackA.isEmpty())
            stackB.push(stackA.pop());
    }

    public static void main(String[] args) {
        RealizeQueueByStack realizeQueueByStack = new RealizeQueueByStack();
        realizeQueueByStack.enQueue(1);
        realizeQueueByStack.enQueue(2);
        realizeQueueByStack.enQueue(3);
        System.out.println(realizeQueueByStack.deQueue());
        System.out.println(realizeQueueByStack.deQueue());
        realizeQueueByStack.enQueue(4);
        System.out.println(realizeQueueByStack.deQueue());
        System.out.println(realizeQueueByStack.deQueue());
    }
}
