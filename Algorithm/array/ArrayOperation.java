package com.tuniu.cls.rcl.algorithm.array;

import java.util.Arrays;

/**
 * 实现数组的插入操作
 *
 * @date 2019/12/16 13:53
 */

public class ArrayOperation {

    private int[] arrays;
    private int size;

    public ArrayOperation(int capacity) {
        this.arrays = new int[capacity];
        size = 0;
    }

    /**
     * 数据插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(int element, int index) throws IndexOutOfBoundsException {
        //判断插入的位置是不是合法(判断下标是否超过范围)
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过数组实际元素范围");
        }
        //如果实际元素达到上限，扩容
        if (size >= arrays.length) {
            resize();
        }

        //从右向左移动元素，找到腾位置的地方，插入元素 方法1
        if (size - index >= 0) System.arraycopy(arrays, index, arrays, index + 1, size - index);
        //从右向左移动元素，找到腾位置的地方，插入元素 方法2
        for (int i = size - 1; i >= index; i--) {
            arrays[i + 1] = arrays[i];
        }
        arrays[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] arrayNew = new int[arrays.length * 2];
        //从之前的数据复制到新数组中
        System.arraycopy(arrays, 0, arrayNew, 0, arrays.length);
        arrays = arrayNew;
    }

    public int delete(int index) throws Exception {
        //判断访问下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出实际数据范围");
        }
        int deletedElement = arrays[index];
        //从左向右循环，将元素逐个向左挪1个位置
        for (int i = index;i<size -1;i++){
            arrays[i] = arrays[i+1];
        }
        size--;
        System.out.println(deletedElement);
        return deletedElement;
    }


    /**
     * 输出数组
     */
    public void output() {
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
        System.out.println("_______________");
        for (int each : arrays) {
            System.out.println(arrays[each]);
        }
        System.out.println("_______________");
        System.out.println(Arrays.toString(arrays));
    }


    public static void main(String[] args) throws Exception {
        ArrayOperation myArray = new ArrayOperation(10);
        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 1);
        myArray.output();
        myArray.delete(2);
    }

}
