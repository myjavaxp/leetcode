package com.yibo.leetcode.structrue.list;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings({"unchecked"})
public class Array<E> implements Serializable {
    private static final long serialVersionUID = -3926745631703053617L;
    private E[] data;
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 数组最大容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] data) {
        this.data = (E[]) new Object[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
        this.size = data.length;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 获取Array容量
     *
     * @return Array 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 是否是空Array
     *
     * @return 是否是空Array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (size == getCapacity()) {
            int grow = data.length >> 1;
            int newCapacity = data.length + (grow > 0 ? grow : 1);
            resize(newCapacity);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size");
        }
        E result = data[index];
        if (size - index - 1 >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        size--;
        data[size] = null;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
            return true;
        } else {
            return false;
        }
    }

    public void removeAllElements(E e) {
        if (removeElement(e)) {
            removeAllElements(e);
        }
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}