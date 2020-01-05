package com.tuniu.cls.rcl.algorithm.queue;

/**
 * 循环对列
 *
 * @date 2019/12/18 10:20
 */

public class MyLoopQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyLoopQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队元素
     */
    public void enQueue(int element) throws Exception {
        //判断队列是不是已经满了
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满,不能再入队了");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     *
     * @return 出队元素
     */
    public int deQueue() throws Exception {
        //判断队列是不是已经空了
        if (rear == front)
            throw new Exception("队列已经空了，不能再出队了");
        int deQueue = array[front];
        front = (front + 1) % array.length; //front + 1 往后移动一个位置，少一个元素，不是front-1，这样是多一个元素
        return deQueue;
    }

    /**
     * 输出循环队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {

        MyLoopQueue myLoopQueue = new MyLoopQueue(6);
        myLoopQueue.enQueue(5);
        myLoopQueue.enQueue(6);
        myLoopQueue.enQueue(8);
        myLoopQueue.enQueue(1);
        myLoopQueue.deQueue();
        myLoopQueue.deQueue();
        myLoopQueue.deQueue();
        myLoopQueue.enQueue(2);
        myLoopQueue.enQueue(4);
        myLoopQueue.enQueue(9);
        myLoopQueue.output();
    }

}
