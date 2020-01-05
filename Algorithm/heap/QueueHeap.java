package com.tuniu.cls.rcl.algorithm.heap;

import org.apache.commons.collections.IterableMap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 用队列实现二叉堆
 * <p>
 * 小顶堆
 *
 * @date 2019/12/24 18:01
 */

public class QueueHeap {

    private int[] array;
    private int size;

    public QueueHeap() {
        //队列初始长度
        array = new int[32];
    }

    /**
     * 队列扩容
     */
    public void resize() {
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 入队
     *
     * @param key 入队元素
     */
    public void enQueue(int key) {
        //队列长队超出范围，扩容
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     *
     * @return 出队的元素
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (size < 0) throw new Exception();
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp保存插入的叶子结点值，用于最后赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust() {
        //temp保存父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            //如果没有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子节点，直接跳出
            if (temp >= array[childIndex]) break;
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) throws Exception {
        QueueHeap queueHeap = new QueueHeap();
        queueHeap.enQueue(3);
        queueHeap.enQueue(5);
        queueHeap.enQueue(10);
        queueHeap.enQueue(2);
        queueHeap.enQueue(7);
        System.out.println("出队"+queueHeap.deQueue());
        System.out.println("出队"+queueHeap.deQueue());
    }

}
