package com.tuniu.als.tnl.kzds;

import java.util.Iterator;

public class KzLinkedListImpl implements KzLinkedList {
    private static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    Node head = null;
    private int size;

    @Override
    public int size() {
//        Node node = head;
//        int size =0 ;
//        while (node.next!= null){
//            size++;
//            node=node.next;
//        }
//        return size+1;
        return size;
    }

    @Override
    public int get(int idx) {

        // Node node = head;
//        for (int i = 0; i <idx; i++) {
//             node = node.next;
//        }
//        while (idx-->0){
//            node = node.next;
//        }

//        Node node = getNode(idx);
//       return node.val;
        return getNode(idx).val;
    }


    @Override
    public void add(int val) {
        // Node node = head;
        // int len = size-1;
//        while (len-->0){
//            node = node.next;
//        }
        if (head == null) {
            head = new Node(val);
        } else {
            Node node = getNode(size - 1);
            node.next = new Node(val);
        }
        size++;
    }

    private Node getNode(int idx) {
        if (idx >= size || idx < 0) throw new IndexOutOfBoundsException();
        Node node = head;
        while (idx-- > 0) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

//    public void addFirst2(int val){
//        head = foo(val, (head, node) -> {
//            node.next = head;
//            head = node;
//            return head;
//        });
//        size++;
//    }
//
//    private Node foo(int val,  BiFunction<Node, Node, Node> function){
//        Node node = new Node(val);
//        if (head == null) {
//            head = node;
//        } else {
//            head = function.apply(head, node);
//        }
//        return head;
//    }

    @Override
    public void addLast(int val) {
        add(val);
    }

    @Override
    public int remove(int idx) {
        Node node = head;
        int indexVal;
        if (head == null || idx >= size) {
            throw new IndexOutOfBoundsException();
        } else if (idx == 0) {
            indexVal = head.val;
            head = head.next;
        } else {
//            while (idx-- > 1) {
//                node = node.next;
//            }
            node = getNode(idx - 1);
            indexVal = node.next.val;
            node.next = node.next.next;
        }
        size--;
        return indexVal;
    }

    @Override
    public int removeFirst() {
        return remove(0);
    }

    @Override
    public int removeLast() {
        return remove(size - 1);
    }

    @Override
    public void set(int idx, int val) {
       Node node = getNode(idx);
       node.val = val;
    }

    @Override
    public void insert(int idx, int val) {
        Node node = getNode(idx -1);
        if (idx>0){
            add(val);
        }else if(idx ==0){
            addFirst(val);
        }
        node=node.next;
        size++;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(head);
    }

    private static class LinkedListIterator implements Iterator<Integer>{

        private Node curNode;

        LinkedListIterator(Node head){
            this.curNode = head;
        }

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public Integer next() {
            int val = curNode.val;
            curNode = curNode.next;
            return val;
        }
    }
}
