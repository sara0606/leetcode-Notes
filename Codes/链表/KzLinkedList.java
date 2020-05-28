package com.tuniu.als.tnl.kzds;

import java.util.Iterator;

public interface KzLinkedList {

    int size();

    int get(int idx);

    void add(int val);
    void addFirst(int val);
    void addLast(int val);

    int remove(int idx);
    int removeFirst();
    int removeLast();

    void set(int idx, int val);
    void insert(int idx, int val);

    Iterator<Integer> iterator();
}
