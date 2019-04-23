package com.yibo.leetcode.structrue.list;

import java.io.Serializable;
import java.util.Arrays;

public class Array<E> implements Serializable {
    private static final long serialVersionUID = -3926745631703053617L;
    private E[] data;
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 数组最大容量
     */
    @SuppressWarnings({"unchecked"})
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @SuppressWarnings({"unchecked"})
    @SafeVarargs
    public Array(E... a) {
        if (a == null) {
            data = (E[]) new Object[0];
        } else {
            this.data = (E[]) new Object[a.length];
            System.arraycopy(a, 0, this.data, 0, a.length);
            this.size = data.length;
        }
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

    public void add(E e) {
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
        System.arraycopy(data, index, data, index + 1, size - index);
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
        System.arraycopy(data, index + 1, data, index, size - index - 1);
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
        if (i != j) {
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        s.append('[');
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        s.append(']');
        return s.toString();
    }
}