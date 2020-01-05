package com.tuniu.cls.rcl.algorithm.linkedlist;

/**
 * 链表操作
 *
 * @date 2019/12/16 15:09
 */

public class MyLinkedList {

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //头结点指针
    private Node head;
    //尾结点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 链表插入元素
     *
     * @param data  插入元素
     * @param index 插入位置
     */
    public void inset(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //头插
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //尾插
            last.next = head;
            last = insertNode;
        } else {
            //插入中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     *
     * @param index 删除节点的位置
     * @return 删除的节点值
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        //判断下标位置是不是超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头结点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾结点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }


    /**
     * 链表查找元素
     *
     * @param index 查找位置
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args)throws Exception{
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.inset(3,0);
        myLinkedList.inset(7,1);
        myLinkedList.inset(9,2);
        myLinkedList.inset(5,3);
        myLinkedList.inset(6,1);
        myLinkedList.remove(0);
        myLinkedList.output();
    }

}
