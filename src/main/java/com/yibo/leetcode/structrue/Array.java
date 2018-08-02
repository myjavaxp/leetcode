package com.yibo.leetcode.structrue;

import java.io.Serializable;

public class Array implements Serializable {
	private static final long serialVersionUID = -3926745631703053617L;
	private int[] data;
	private int size;

	/**
	 * 构造函数
	 * 
	 * @param capacity 数组最大容量
	 */
	public Array(int capacity) {
		data = new int[capacity];
		size = 0;
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
	public int getSize() {
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

	public void addFirst(int e) {
		add(0, e);
	}

	public void addLast(int e) {
		add(size, e);
	}

	public void add(int index, int e) {
		if (size == getCapacity()) {
			throw new IllegalArgumentException("Add failed. Array is full.");
		}
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
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
